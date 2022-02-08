package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.stock.dao.UserDao;
import com.stock.logger.Logger;
import com.stock.model.User;
import com.stock.util.ConnectionUtil;

public class UserImpl implements UserDao {

	private static final String WALLET = "wallet";
	private static final String USER_NAME = "user_name";
	private static final String USER_ID = "user_id";
	private static final String PHONENUMBER = "phonenumber";
	private static final String EMAIL = "email";
	private static final String ADDRESS = "address";

	public int insert(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = ConnectionUtil.gbConnection();
			String query = "insert into users(user_name,email,address,password,phonenumber)values(?,?,?,?,?)";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getPassword());
			pstmt.setLong(5, user.getPhoneNumber());
			rows = pstmt.executeUpdate();

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}
		return rows;
	}

	public User validateUser(User us) {

		User userlog = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pre = null;

		try {
			con = ConnectionUtil.gbConnection();

			String query = "select user_id,user_name,email,address,password,phonenumber,usertype,wallet from users where email=? and password=?";

			pre = con.prepareStatement(query);
			pre.setString(1, us.getEmail());
			pre.setString(2, us.getPassword());
			rs = pre.executeQuery();
			if (rs.next()) {

				userlog = new User(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL),
						rs.getString(ADDRESS), rs.getLong(PHONENUMBER), rs.getDouble(WALLET),
						rs.getString("usertype"));

			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pre, con);
		}

		return userlog;
	}

	public void updated(User userupdate) {

		String updateQuery = "update users set  password=? where phonenumber=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(updateQuery);

			pstmt.setString(1, userupdate.getPassword());
			pstmt.setLong(2, userupdate.getPhoneNumber());
			pstmt.executeUpdate();

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public void wallet(User userwallet) {

		String updatewallet = "update users set  WALLET=wallet + ? where password=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(updatewallet);

			pstmt.setDouble(1, userwallet.getWallet());
			pstmt.setString(2, userwallet.getPassword());
		    pstmt.executeUpdate();

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public double walletAmount(int userid) {

		String updatewallet = "select wallet from users where user_id=?";
		double wallet =0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(updatewallet);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				wallet = rs.getDouble(WALLET);
			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return wallet;
	}

	public List<User> showuser() {
		List<User> adminuserview = new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String showquery = "select user_id,user_name,email,address,phonenumber,wallet from users where usertype='user'";

		try {

			con = ConnectionUtil.gbConnection();

			pstmt = con.prepareStatement(showquery);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				User user = new User(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL),
						rs.getString(ADDRESS), rs.getLong(PHONENUMBER), rs.getDouble(WALLET));
				adminuserview.add(user);

			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return adminuserview;

	}

	public List<User> userview(int userid) {
		List<User> userDetails = new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String usershow = "select user_id,user_name,email,address,phonenumber,wallet from users where user_id=?";
		try {

			con = ConnectionUtil.gbConnection();

			pstmt = con.prepareStatement(usershow);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				User user = new User(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL),
						rs.getString(ADDRESS), rs.getLong(PHONENUMBER), rs.getDouble(WALLET));
				userDetails.add(user);

			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return userDetails;

	}

}
