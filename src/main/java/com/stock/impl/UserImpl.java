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

	
	public  int insert(User users)  {
		Connection con;
		int i=0;
		try {
			con = ConnectionUtil.gbConnection();
String query="insert into users(user_name,email,address,password,phonenumber)values(?,?,?,?,?)";

			PreparedStatement pstmt = null;
		
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, users.getUserName());
				pstmt.setString(2, users.getEmail());
				pstmt.setString(3, users.getAddress());
				pstmt.setString(4, users.getPassword());
				pstmt.setLong(5, users.getPhoneNumber());
				i=pstmt.executeUpdate();
				System.out.println("Register success");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return i;
					
	}

	public ResultSet validateUser(User us)   {
    User user=null;
	String	emailid=null;
	String	password=null;
		ConnectionUtil connect=new ConnectionUtil();
		ResultSet rs=null;
		try {
			
			
		
				Connection con = null;
				try {
					con = connect.gbConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("hello"+us.getEmail()+" "+us.getPassword());
			String query="select user_id,user_name,email,address,password,phonenumber,usertype,wallet from users where email='"+us.getEmail()+"' and password='"+us.getPassword()+"'";
			
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" statement error");
		}
		
		// TODO Auto-generated method stub
		return rs;
	}
	
	public void updated(User userupdate) {

		String updateQuery = "update users set  password=? where phonenumber=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);

			pstmt.setString(1, userupdate.getPassword());
			pstmt.setLong(2, userupdate.getPhoneNumber());
			int i = pstmt.executeUpdate();
			System.out.println(i + "updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void delete(User userdelete) {

		String deleteQuery = "delete from users where  email=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);

			pstmt.setString(1, userdelete.getEmail() );
			int i = pstmt.executeUpdate();
			System.out.println(i + "delete");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void wallet(User userwallet) {

		String updatewallet = "update users set  WALLET=wallet + ? where password=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(updatewallet);

			pstmt.setDouble(1,userwallet.getWallet());
			pstmt.setString(2, userwallet.getPassword());
			int i = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
			System.out.println(i + "updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public User walletAmount(int userid){
		
		String updatewallet = "select wallet from users where user_id=?";
		User user=null;
	try {
			Connection con = null;
			try {
				con = ConnectionUtil.gbConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement pstmt = con.prepareStatement(updatewallet);
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
				
				 user=new User(rs.getDouble(1));
				System.out.println(user);
				
				
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
				
				
				
	}		
	
	public  List<User> showuser()  {
		List<User> adminuserview=new ArrayList<User>();
		Connection con;
		ResultSet rs=null;
		
		
		
          String showquery="select user_id,user_name,email,address,password,phonenumber,wallet from users";
			
	
		
			try {
				
				con = ConnectionUtil.gbConnection();
				
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery(showquery);
         while(rs.next()) {
					
					User user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getDouble(7));
					adminuserview.add(user);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return adminuserview;
			
	
	
	
	}
	public  List<User> userview(int userid)  {
		List<User> userDetails= new ArrayList<User>();
		Connection con;
		ResultSet rs=null;
	 String usershow= "select user_id,user_name,email,address,password,phonenumber,wallet from users where user_id=?";
			try {
				
				con = ConnectionUtil.gbConnection();
				
				PreparedStatement pstmt = con.prepareStatement(usershow);
				pstmt.setInt(1, userid);
				 rs=pstmt.executeQuery();
				while(rs.next()) {
					
					User user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getDouble(7));
					userDetails.add(user);
				}
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userDetails;
			
	
	
	
	}
	

	
}

	
	

