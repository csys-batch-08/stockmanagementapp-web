package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.StockDao;
import com.stock.model.Stock;
import com.stock.util.ConnectionUtil;

public class StockImpl  implements StockDao{

	public ResultSet showProduct() {
		String prod = "select * from stock";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(prod);
//			while (rs.next()) {
//				System.out.format("%-5s%-15s%-10s%-5s\n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
//				//System.out.println();
//			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet serachProduct(String proName) {
		String pro = "select * from stock where lower(product_name ) like '"+proName  +"%' ";
				ResultSet rs=null;
		try {
			System.out.println("sercahpro"+proName);
			Connection con = ConnectionUtil.gbConnection();

			
			
			PreparedStatement pre=con.prepareStatement(pro);
			
			
			rs = pre.executeQuery();
//			if(rs.next()) {
//				System.out.println(rs.getString(1) + "xcvbghnjk");
//			}
		System.out.println("serach");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public String getProduct (String productName) {
		
		String check= "select product_name from stock where product_name=? ";
		
		Connection con = null;
		String proname=null;
		System.out.println("hey");
		
			try {
				con = ConnectionUtil.gbConnection();
				PreparedStatement pstmt = con.prepareStatement(check);
				
				pstmt.setString(1, productName);
				
				ResultSet rs=pstmt.executeQuery();
				System.out.println("helllo");
				
				if(rs.next()) {
					System.out.println("helo");
					
					proname=rs.getString(1);
					
				}
				

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		return proname;
		
		
	}
	
	
	
	
	
	

	public void insert(Stock pro) {

		String insertQuery = "insert into stock (product_name,product_qty ,price) values (?,?,?)";

		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			System.out.println(pro.getProductName() + pro.getQuantity() + pro.getUnitPrice());

			pstmt.setString(1, pro.getProductName());
			pstmt.setInt(2, pro.getQuantity());
			pstmt.setDouble(3, pro.getUnitPrice());
			int i = pstmt.executeUpdate();
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

	public void Adminupdated(Stock pro1) {

	String updateQuery = "update stock set product_qty = product_qty + ? where product_name=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);

			pstmt.setInt(1, pro1.getQuantity());
			pstmt.setString(2, pro1.getProductName());
			System.out.println(pro1.getQuantity());
			System.out.println(pro1.getProductName());
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
	public void updateQuantity(int proid,int qty) {

		String updateQuery = "update stock set product_qty = product_qty - ? where product_id=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);

			pstmt.setInt(1, qty);
			pstmt.setInt(2, proid);
			int i = pstmt.executeUpdate();
			System.out.println(i + "updated");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void delete(Stock pro2) {

		String deleteQuery = "delete from stock where product_id=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);

			pstmt.setInt(1, pro2.getProductId());
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

	public ResultSet validateProduct(String proName) {

		String validdateQuery = "select * from stock where product_name=?";

		
		try {
			Connection con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(validdateQuery);
			pstmt.setString(1, proName);
			ResultSet rs = pstmt.executeQuery();
			return rs;
//			if (rs.next()) {
//				Stock stock = new Stock(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
//				System.out.println();
//            return stock;
//			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	

	}
	public Stock validateProductId(int productId) {

		String validdateQuery = "select *from stock where product_id=?";

		try {
			Connection con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(validdateQuery);
			pstmt.setInt(1, productId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Stock stock = new Stock(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				System.out.println();
            return stock;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
