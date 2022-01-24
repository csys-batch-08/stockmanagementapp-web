package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stock.dao.PurchaseDao;
import com.stock.model.Purchase;
import com.stock.util.ConnectionUtil;

public class PuruchaseImpl  implements PurchaseDao{
public int insert(Purchase purchase)  {
	String updateQuery1="select wallet from users where user_id='"+purchase.getUserId()+"'";	
	String updateQuery="update users set wallet=(select wallet from users where user_id=?)-? where user_id=?";
		String insertQuery="insert into purchases_list (product_id,user_id,product_name,quantity,total_price )values (?,?,?,?,?)";
		int num=0;
		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			Statement st=con.createStatement();
			ResultSet rs2=st.executeQuery(updateQuery1);
			double wallet=0;
			if(rs2.next()) {
				wallet=rs2.getDouble(1);
			}
			if(wallet>purchase.getTotalPrice()) {
			PreparedStatement pstmt1= con.prepareStatement(updateQuery);
			pstmt1.setInt(1, purchase.getUserId());
			pstmt1.setDouble(2, purchase.getTotalPrice());
			pstmt1.setInt(3, purchase.getUserId());
			int j=pstmt1.executeUpdate();
			System.out.println("updated"+j);
			
			PreparedStatement pstmt= con.prepareStatement(insertQuery);
			pstmt.setInt(1, purchase.getProductId());
			pstmt.setInt(2, purchase.getUserId());
			pstmt.setString(3, purchase.getProductName());
			pstmt.setInt(4, purchase.getOrderQty());
			pstmt.setDouble(5, purchase.getTotalPrice());
			//pstmt.setDate(5, new java.sql.Date( purchase.getOrderDate().getTime()));
			int i=pstmt.executeUpdate();
			System.out.println(i+ "inserted");
			pstmt.close();
			con.close();
			}else {
				//System.out.println("low bal");
				num=5;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
			}

public void updated(Purchase purchase1 )  {
		
		String insertQuery="update purchases set product_name=? where user_id=?";
		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt= con.prepareStatement(insertQuery);
			
		     pstmt.setString(1, purchase1.getProductName());
	         pstmt.setInt(2, purchase1.getUserId());
	   	     int i=pstmt.executeUpdate();
		     System.out.println(i+"updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
	public void delete(Purchase  purchase2)  {
	
	String deleteQuery="delete from purchases where  product_name=?";
	
	Connection con;
	try {
		con = ConnectionUtil.gbConnection();
		PreparedStatement pstmt= con.prepareStatement(deleteQuery);

		pstmt.setString(1, purchase2.getProductName());
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
	
	public ResultSet showPurchase() {
		String showquery = "select * from purchases_list";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(showquery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet userPurchaselist(int userid) {
		String usershow = "select * from purchases_list where user_id =?";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt= con.prepareStatement(usershow);

			pstmt.setInt(1, userid);
			
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

		
		


}

