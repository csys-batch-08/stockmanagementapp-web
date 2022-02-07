package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

import com.stock.dao.CartDao;
import com.stock.logger.Logger;
import com.stock.model.Cart;
import com.stock.util.ConnectionUtil;

public class CartImpl implements CartDao {

	private static final String USER_ID = "user_id";
	private static final String TOTAL_PRICE = "totalPrice";
	private static final String QUANTITY = "quantity";
	private static final String DELIVERY_DATE = "delivery_date";
	private static final String CART_ID = "cart_id";
	private static final String PRODUCT_ID = "product_id";

	@Override
	public void insert(Cart cart) {

		String insertQuery = "	insert into cart (user_id,product_id,quantity,totalprice,delivery_date) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getProductId());
			pstmt.setInt(3, cart.getQunatity());
			pstmt.setDouble(4, (cart.getQunatity() * cart.getTotalPrice()));
			pstmt.setDate(5, new java.sql.Date(cart.getExpectedDate().getTime()));
			pstmt.executeUpdate();

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	@Override
	public List<Cart> allcart(int userid) {

		String insertquery = "select * from cart where cart_id=(select max(cart_id) from cart) and user_id = ?";
		List<Cart> usercart = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(insertquery);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Cart cart1 = new Cart(rs.getInt(CART_ID), rs.getInt(USER_ID), rs.getInt(PRODUCT_ID),
						rs.getInt(QUANTITY), rs.getDouble(TOTAL_PRICE), rs.getDate(DELIVERY_DATE));

				usercart.add(cart1);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return usercart;

	}

	@Override
	public void delete(Cart cart) {

		String deleteQuery = "delete from cart where  product_id=? and user_id=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(deleteQuery);

			pstmt.setInt(1, cart.getProductId());
			pstmt.setInt(2, cart.getUserId());

			pstmt.executeUpdate();

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public List<Cart> viewCart() {
		List<Cart> adminCartView = new ArrayList<>();
		String viewquery = "select cart_id,user_id,product_id,quantity,totalPrice,delivery_date from cart ORDER BY cart_id";
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.gbConnection();
			stmt = con.prepareStatement(viewquery);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Cart cart = new Cart(rs.getInt(CART_ID), rs.getInt(USER_ID), rs.getInt(PRODUCT_ID),
						rs.getInt(QUANTITY), rs.getDouble(TOTAL_PRICE), rs.getDate(DELIVERY_DATE));
				adminCartView.add(cart);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, stmt, con);
		}

		return adminCartView;

	}

	public List<Cart> viewcartuser(int userid) {

		String insertquery = "select cart_id,user_id,product_id,quantity,totalPrice,delivery_date from cart where user_id = ?";
		List<Cart> usercartview = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(insertquery);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Cart cart1 = new Cart(rs.getInt(CART_ID), rs.getInt(USER_ID), rs.getInt(PRODUCT_ID),
						rs.getInt(QUANTITY), rs.getDouble(TOTAL_PRICE), rs.getDate(DELIVERY_DATE));

				usercartview.add(cart1);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return usercartview;

	}

}
