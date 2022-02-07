package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

import com.stock.dao.StockDao;
import com.stock.logger.Logger;
import com.stock.model.Stock;
import com.stock.util.ConnectionUtil;

public class StockImpl implements StockDao {

	private static final String PRODUCT_QTY = "product_qty";
	private static final String PRODUCT_ID = "product_id";
	private static final String PRODUCT_NAME = "product_name";

	public List<Stock> showProducts() {
		List<Stock> productsList = new ArrayList<>();

		String query = "select product_id,product_name,product_qty,price from stock ORDER BY product_id";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Stock stock = new Stock(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getInt(PRODUCT_QTY),rs.getDouble("price"));
				productsList.add(stock);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return productsList;
	}

	public List<Stock> serachProduct(String proName) {
		List<Stock> searchproducts = new ArrayList<>();
		String pro = "select product_id,product_name,product_qty,price from stock where lower(product_name ) like  ?  ";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {

			con = ConnectionUtil.gbConnection();

			pstmt = con.prepareStatement(pro);

			pstmt.setString(1, proName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Stock stock = new Stock(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getInt(PRODUCT_QTY),
						rs.getDouble("price"));
				searchproducts.add(stock);

			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}
		return searchproducts;
	}

	public String getProduct(String productName) {

		String check = "select product_name from stock where product_name=? ";

		Connection con = null;
		String proname = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(check);

			pstmt.setString(1, productName);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				proname = rs.getString(PRODUCT_NAME);

			}

		}  catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return proname;

	}

	public void insert(Stock pro) {

		String insertQuery = "insert into stock (product_name,product_qty ,price) values (?,?,?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(insertQuery);

			pstmt.setString(1, pro.getProductName());
			pstmt.setInt(2, pro.getQuantity());
			pstmt.setDouble(3, pro.getUnitPrice());
		    pstmt.executeUpdate();

		}  catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public void adminupdate(Stock pro1) {

		String updateQuery = "update stock set product_qty = product_qty + ? where product_name=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(updateQuery);

			pstmt.setInt(1, pro1.getQuantity());
			pstmt.setString(2, pro1.getProductName());
		    pstmt.executeUpdate();

		}  catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public void updateQuantity(int proid, int qty) {

		String updateQuery = "update stock set product_qty = product_qty - ? where product_id=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(updateQuery);

			pstmt.setInt(1, qty);
			pstmt.setInt(2, proid);
			pstmt.executeUpdate();

		}  catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public void delete(Stock pro2) {

		String deleteQuery = "delete from stock where product_id=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(deleteQuery);

			pstmt.setInt(1, pro2.getProductId());
		    pstmt.executeUpdate();

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public List<Stock> validateProduct(String proName) {
		List<Stock> products = new ArrayList<>();
		String validdateQuery = "select product_id,product_name,product_qty,price from stock where product_name=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(validdateQuery);
			pstmt.setString(1, proName);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Stock stock = new Stock(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getInt(PRODUCT_QTY),
						rs.getDouble("price"));
				products.add(stock);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return products;

	}

	public Stock validateProductId(int productId) {

		String validdateQuery = "select product_id,product_name,product_qty,price from stock where product_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Stock stock=null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(validdateQuery);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
	      stock = new Stock(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getInt(PRODUCT_QTY),rs.getDouble("price"));

				

			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return stock;

	}

}
