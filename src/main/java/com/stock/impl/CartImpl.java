package com.stock.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.stock.dao.CartDao;
import com.stock.model.Cart;
import com.stock.model.Purchase;
import com.stock.util.ConnectionUtil;

public class CartImpl implements CartDao {

	public void insert(Cart cart) {

//		String insertQuery = "insert into cart (user_id,product_id,quantity,totalPrice) values (?,?,?,?)";
		String insertQuery="	insert into cart (user_id,product_id,quantity,totalprice,delivery_date) values(?,?,?,"+cart.getQunatity()+"*?,sysdate+?)";
		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(insertQuery);

			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getProductId());
			pstmt.setInt(3, cart.getQunatity());
			pstmt.setDouble(4, cart.getTotalPrice());
			pstmt.setInt(5, cart.getExpectedDate());
//			pstmt.setDate(5, new java.sql.Date(cart.getExpectedDate().getTime()));
			int i = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
			System.out.println(i + "inserted");
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
public ResultSet allcart(int userid){
	//List<Cart>cartDetails=new ArrayList<Cart>();
	//String insertquery="select*from cart where user_id=?";
	String insertquery="select * from cart where cart_id=(select max(cart_id) from cart) and user_id = ?";
	
	ResultSet rs=null;
	try {
		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pstmt = con.prepareStatement(insertquery);
		pstmt.setInt(1, userid);
		rs=pstmt.executeQuery();
//		while(rs.next()){
//			
//			Cart cart1=new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
//			System.out.println(cart1);
//			cartDetails.add(cart1);
//			System.out.println(cart1);
//			
//		}} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
			
			
			
}		
	public void delete(Cart cart) {
		
		String deleteQuery="delete from cart where  product_id=? and user_id=?";
		
		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt= con.prepareStatement(deleteQuery);
			
			pstmt.setInt(1, cart.getProductId());
			pstmt.setInt(2, cart.getUserId());
			
			int i=pstmt.executeUpdate();
			System.out.println(i+"delete");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
		
			
			
	public ResultSet viewCart(){
		
		String viewquery="select * from cart ";
		
		ResultSet rs=null;
		try {
			Connection con = null;
			try {
				con = ConnectionUtil.gbConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(viewquery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	
			
			
}		}


