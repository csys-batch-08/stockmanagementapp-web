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
		String updateQuery1 = "select wallet from users where user_id= ? ";

		String updateQuery = "update users set wallet= wallet - ? where user_id=?";

		String insertQuery = "insert into purchases_list (product_id,user_id,product_name,quantity,total_price )values (?,?,?,?,?)";
		int num = 0;
		Connection con = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs2 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt3 = con.prepareStatement(updateQuery1);
			pstmt3.setInt(1, purchase.getUserId());
			rs2 = pstmt3.executeQuery();
			double wallet = 0;
			if (rs2.next()) {
				wallet = rs2.getDouble(1);
			}
			if (wallet > purchase.getTotalPrice()) {
				pstmt1 = con.prepareStatement(updateQuery);
				pstmt1.setDouble(1, purchase.getTotalPrice());
				pstmt1.setInt(2, purchase.getUserId());

			    pstmt1.executeUpdate();
				

				pstmt = con.prepareStatement(insertQuery);
				pstmt.setInt(1, purchase.getProductId());
				pstmt.setInt(2, purchase.getUserId());
				pstmt.setString(3, purchase.getProductName());
				pstmt.setInt(4, purchase.getOrderQty());
				pstmt.setDouble(5, purchase.getTotalPrice());

			    pstmt.executeUpdate();
				
			} else {

				num = 5;
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {

			try {
				if (rs2 != null) {

					rs2.close();
				}

				if (pstmt3 != null) {
					pstmt3.close();
				}
				if (pstmt != null) {

					pstmt.close();
				}
				if (pstmt1 != null) {

					pstmt1.close();
				}
				if (con != null) {
					con.close();
				}
			}

			catch (SQLException | NumberFormatException e) {

				e.printStackTrace();
			}
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
