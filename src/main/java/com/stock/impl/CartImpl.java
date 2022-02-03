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
import com.stock.model.Stock;
import com.stock.util.ConnectionUtil;

public class CartImpl implements CartDao {

	public void insert(Cart cart) {


		String insertQuery="	insert into cart (user_id,product_id,quantity,totalprice,delivery_date) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.gbConnection();
		    pstmt = con.prepareStatement(insertQuery);

			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getProductId());
			pstmt.setInt(3, cart.getQunatity());
			pstmt.setDouble(4,( cart.getQunatity()* cart.getTotalPrice()));
			pstmt.setDate(5,new java.sql.Date(cart.getExpectedDate().getTime()));

			

			int i = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
			System.out.println(i + "inserted");
			pstmt.close();
			con.close();
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
	
public List<Cart> allcart(int userid){
	
	String insertquery="select * from cart where cart_id=(select max(cart_id) from cart) and user_id = ?";
	List<Cart> usercart=new ArrayList<Cart>();
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	Connection con = null;
	
	try {
		try {
			con = ConnectionUtil.gbConnection();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		 pstmt = con.prepareStatement(insertquery);
		pstmt.setInt(1, userid);
		 rs = pstmt.executeQuery();
	while(rs.next()){
			
		Cart cart1=new Cart(rs.getInt("cart_id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getDouble("totalPrice"), rs.getDate("delivery_date"));
			
			usercart.add(cart1);
			
		}} catch (SQLException e) {
		
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

	return usercart;
			
			
			
}		
	public void delete(Cart cart) {
		
		String deleteQuery="delete from cart where  product_id=? and user_id=?";
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt= con.prepareStatement(deleteQuery);
			
			pstmt.setInt(1, cart.getProductId());
			pstmt.setInt(2, cart.getUserId());
			
			int i=pstmt.executeUpdate();
			

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
		
		
			
	public List<Cart> viewCart(){
		List<Cart> adminCartView = new ArrayList<Cart>();
		String viewquery="select cart_id,user_id,product_id,quantity,totalPrice,delivery_date from cart ORDER BY cart_id";
		    Statement stmt=null;
			Connection con = null;
			ResultSet	rs =null;
			try {
				try {
					con = ConnectionUtil.gbConnection();
					 stmt = con.createStatement();
						rs = stmt.executeQuery(viewquery);
					while(rs.next()){
						
						Cart cart=new Cart(rs.getInt("cart_id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getDouble("totalPrice"), rs.getDate("delivery_date"));
						 adminCartView.add(cart);
						    
					}
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			} catch (SQLException e) {
			
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

		return adminCartView;
	
			
	}	
	public List<Cart> viewcartuser(int userid){
		
		String insertquery="select cart_id,user_id,product_id,quantity,totalPrice,delivery_date from cart where user_id = ?";
		List<Cart> usercartview=new ArrayList<Cart>();
		PreparedStatement pstmt=null;
		Connection con = null;
		
		try {
			try {
				con = ConnectionUtil.gbConnection();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			 pstmt = con.prepareStatement(insertquery);
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
				
				Cart cart1=new Cart(rs.getInt("cart_id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getInt("quantity"), rs.getDouble("totalPrice"), rs.getDate("delivery_date"));
				
				usercartview.add(cart1);
				
			}
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

		return usercartview;
				
				
				
	}		

		}


