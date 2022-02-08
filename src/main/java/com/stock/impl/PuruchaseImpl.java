package com.stock.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.stock.dao.PurchaseDao;
import com.stock.logger.Logger;
import com.stock.model.Purchase;
import com.stock.util.ConnectionUtil;

public class PuruchaseImpl implements PurchaseDao {
	public int insert(Purchase purchase) {
		String walletAmount = "select wallet from users where user_id= ? ";

		String walletReduce = "update users set wallet= wallet - ? where user_id=?";

		String insertQuery = "insert into purchases_list (product_id,user_id,product_name,quantity,total_price )values (?,?,?,?,?)";
		int num = 0;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PreparedStatement prestmt = null;
		PreparedStatement pstmt = null;
		double wallet = 0;
		try {
			con = ConnectionUtil.gbConnection();
			preparedStatement = con.prepareStatement(walletAmount);
			preparedStatement.setInt(1, purchase.getUserId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				wallet = resultSet.getDouble(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger.printStackTrace(e);
		} finally {
			ConnectionUtil.close(resultSet, preparedStatement, null);
		}
		
		if (wallet > purchase.getTotalPrice()) {
			try {
			prestmt = con.prepareStatement(walletReduce);
			prestmt.setDouble(1, purchase.getTotalPrice());
			prestmt.setInt(2, purchase.getUserId());

			prestmt.executeUpdate();
		}catch (SQLException |NullPointerException e) {
			Logger.printStackTrace(e);
		} finally {
			ConnectionUtil.close(null, prestmt, null);
		}
			try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, purchase.getProductId());
			pstmt.setInt(2, purchase.getUserId());
			pstmt.setString(3, purchase.getProductName());
			pstmt.setInt(4, purchase.getOrderQty());
			pstmt.setDouble(5, purchase.getTotalPrice());

			pstmt.executeUpdate();
			}catch (SQLException |NullPointerException e) {
				Logger.printStackTrace(e);
			} finally {
				ConnectionUtil.close(null, pstmt, con);
			}

		} else {

			num = 5;
		}

		return num;

}

	

	

	public List<Purchase> viewpurchase() {
		List<Purchase> adminpurchaseview = new ArrayList<>();
		String showquery = "select oreder_id,product_id,user_id,product_name,quantity,total_price,status,order_date from purchases_list order by oreder_id desc";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.gbConnection();

			pstmt = con.prepareStatement(showquery);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Purchase purchase = new Purchase(rs.getInt("oreder_id"), rs.getInt("product_id"), rs.getInt("user_id"),
						rs.getString("product_name"), rs.getInt("quantity"), rs.getDouble("total_price"),
						rs.getString("status"), rs.getDate("order_date"));

				adminpurchaseview.add(purchase);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}
		return adminpurchaseview;

	}

	public List<Purchase> userPurchase(int userid) {

		String userpurchaseshow = "select oreder_id,product_id,user_id,product_name,quantity,total_price,status,order_date from purchases_list where user_id =? order by oreder_id desc";
		List<Purchase> userpurchase = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(userpurchaseshow);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Purchase purchase = new Purchase(rs.getInt("oreder_id"), rs.getInt("product_id"), rs.getInt("user_id"),
						rs.getString("product_name"), rs.getInt("quantity"), rs.getDouble("total_price"),
						rs.getString("status"), rs.getDate("order_date"));

				userpurchase.add(purchase);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return userpurchase;

	}

}
