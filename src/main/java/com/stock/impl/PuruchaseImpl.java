package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.PurchaseDao;
import com.stock.model.Cart;
import com.stock.model.Purchase;
import com.stock.util.ConnectionUtil;

public class PuruchaseImpl  implements PurchaseDao{
public int insert(Purchase purchase)  {
	String updateQuery1="select wallet from users where user_id='"+purchase.getUserId()+"'";
	
	String updateQuery="update users set wallet= wallet - ? where user_id=?";
	
    String insertQuery="insert into purchases_list (product_id,user_id,product_name,quantity,total_price )values (?,?,?,?,?)";
		int num=0;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs2=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.gbConnection();
			 stmt=con.createStatement();
			 rs2=stmt.executeQuery(updateQuery1);
			double wallet=0;
			if(rs2.next()) {
				wallet=rs2.getDouble(1);
			}
			if(wallet>purchase.getTotalPrice()) {
			 pstmt1= con.prepareStatement(updateQuery);
			pstmt1.setDouble(1, purchase.getTotalPrice());
			pstmt1.setInt(2, purchase.getUserId());
			
	        int j=pstmt1.executeUpdate();
			System.out.println("updated"+j);
			
		    pstmt= con.prepareStatement(insertQuery);
			pstmt.setInt(1, purchase.getProductId());
			pstmt.setInt(2, purchase.getUserId());
			pstmt.setString(3, purchase.getProductName());
			pstmt.setInt(4, purchase.getOrderQty());
			pstmt.setDouble(5, purchase.getTotalPrice());
			
			int i=pstmt.executeUpdate();
			System.out.println(i+ "inserted");
				}else {
				
				num=5;
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(stmt!=null ) {
			       stmt.close();}
			if(rs2!=null) {
				
				rs2.close();
			}if(pstmt!=null) {
				
				pstmt.close();
			}if(pstmt1!=null) {
				
				pstmt1.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

		return num;
		
			}

	
		
	public List<Purchase> viewpurchase(){
		List<Purchase> adminpurchaseview = new ArrayList<Purchase>();
		String showquery = "select oreder_id,product_id,user_id,product_name,quantity,total_price,status,order_date from purchases_list";
		    Statement stmt=null;
			Connection con = null;
			ResultSet	rs=null;
			try {
				
					try {
						con = ConnectionUtil.gbConnection();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 stmt = con.createStatement();
						rs = stmt.executeQuery(showquery);
					while(rs.next()){
						
						Purchase purchase=new Purchase(rs.getInt("oreder_id"), rs.getInt("product_id"), rs.getInt("user_id"), rs.getString("product_name"),
								rs.getInt("quantity"), rs.getDouble("total_price"),rs.getString("status"), rs.getDate("order_date"));
						
						 adminpurchaseview .add(purchase);
						   
					}
				}
			 catch (SQLException e) {
			
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

		return  adminpurchaseview ;
	
			
	}	
	
	public List<Purchase> userPurchase(int userid){
		
		String userpurchaseshow = "select oreder_id,product_id,user_id,product_name,quantity,total_price,status,order_date from purchases_list where user_id =?";
		List<Purchase> userpurchase=new ArrayList<Purchase>();
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			try {
				con = ConnectionUtil.gbConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 pstmt = con.prepareStatement(userpurchaseshow);
			pstmt.setInt(1, userid);
		 rs = pstmt.executeQuery();
		while(rs.next()){
				
			Purchase purchase=new Purchase(rs.getInt("oreder_id"), rs.getInt("product_id"), rs.getInt("user_id"), rs.getString("product_name"),
					rs.getInt("quantity"), rs.getDouble("total_price"),rs.getString("status"), rs.getDate("order_date"));
			
				
				userpurchase.add(purchase);
				
				
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

		return userpurchase;
				
				
				
	}		
		
		


}

