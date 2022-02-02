package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.stock.dao.UserDao;
import com.stock.model.Cart;
import com.stock.model.Stock;
import com.stock.model.User;
import com.stock.util.ConnectionUtil;

public class UserImpl implements UserDao {

	public int insert(User users) {
		Connection con =null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try {
			con = ConnectionUtil.gbConnection();
			String query = "insert into users(user_name,email,address,password,phonenumber)values(?,?,?,?,?)";

		

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, users.getUserName());
			pstmt.setString(2, users.getEmail());
			pstmt.setString(3, users.getAddress());
			pstmt.setString(4, users.getPassword());
			pstmt.setLong(5, users.getPhoneNumber());
			i = pstmt.executeUpdate();
			System.out.println("Register success");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			

			e.printStackTrace();
	}
		finally {
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
				if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		return i;
		}

	

	

	public User validateUser(User us) {
		User user = null;
		User userlog =null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pre=null;
		try {

			
			try {
				con = ConnectionUtil.gbConnection();
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
			
			String query = "select user_id,user_name,email,address,password,phonenumber,usertype,wallet from users where email=? and password=?";

			 pre = con.prepareStatement(query);
			pre.setString(1,us.getEmail() );
			pre.setString(2,us.getPassword() );
			rs = pre.executeQuery();
			while (rs.next()) {

			 userlog = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("email"), rs.getString("address"), rs.getLong("phonenumber"),
						rs.getDouble("wallet"),rs.getString("usertype"));
				
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
				try {if(pre!=null ) {
				       pre.close();}
				if(rs!=null) {
					
					rs.close();
				}
				if(con!=null) {	
						con.close();
					}	}
						
					 catch (SQLException e) {
						
						e.printStackTrace();
					}
				}

		
		return userlog;
	}

	public void updated(User userupdate) {

		String updateQuery = "update users set  password=? where phonenumber=?";
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(updateQuery);

			pstmt.setString(1, userupdate.getPassword());
			pstmt.setLong(2, userupdate.getPhoneNumber());
			int i = pstmt.executeUpdate();
			System.out.println(i + "updated");
			
					} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
				if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

	}

	
	public void wallet(User userwallet) {

		String updatewallet = "update users set  WALLET=wallet + ? where password=?";
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(updatewallet);

			pstmt.setDouble(1, userwallet.getWallet());
			pstmt.setString(2, userwallet.getPassword());
			int i = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
				if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

		

	}

	public User walletAmount(int userid) {

		String updatewallet = "select wallet from users where user_id=?";
		User user = null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con = null;
			try {
				con = ConnectionUtil.gbConnection();
				pstmt = con.prepareStatement(updatewallet);
				 pstmt.setInt(1, userid);
				 rs = pstmt.executeQuery();
					while (rs.next()) {

						user = new User(rs.getDouble("wallet"));
						}

			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				try {if(pstmt!=null ) {
				       pstmt.close();}
				if(rs!=null) {
					
					rs.close();
				}
				if(con!=null) {	
						con.close();
					}	}
						
					 catch (SQLException e) {
						
						e.printStackTrace();
					}
				}

			return user;
	}

			 	
		 
		
           	
	

	public List<User> showuser() {
		List<User> adminuserview = new ArrayList<User>();
		Connection con=null;
		ResultSet rs = null;
		Statement stmt=null;

		String showquery = "select user_id,user_name,email,address,phonenumber,wallet from users where usertype='user'";

		try {

			con = ConnectionUtil.gbConnection();

			 stmt = con.createStatement();
			rs = stmt.executeQuery(showquery);
			while (rs.next()) {

				User user = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("email"), rs.getString("address"), rs.getLong("phonenumber"),
						rs.getDouble("wallet"));
				adminuserview.add(user);
				
				
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(stmt!=null ) {
			       stmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


		return adminuserview;

	}

	public List<User> userview(int userid) {
		List<User> userDetails = new ArrayList<User>();
		Connection con=null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String usershow = "select user_id,user_name,email,address,phonenumber,wallet from users where user_id=?";
		try {

			con = ConnectionUtil.gbConnection();

			 pstmt = con.prepareStatement(usershow);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				User user = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("email"), rs.getString("address"), rs.getLong("phonenumber"),
						rs.getDouble("wallet"));
				userDetails.add(user);
				
						}

		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


		return userDetails;

	}

}
