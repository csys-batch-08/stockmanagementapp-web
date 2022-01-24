package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.stock.model.Stock;
import com.stock.dao.InvoiceDao;
import com.stock.model.Invoice;
import com.stock.util.ConnectionUtil;

public class InvoiceImpl implements InvoiceDao {

	
	
	public ResultSet showInvoice() {
		String invoiceQuery = "select * from invoice";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(invoiceQuery);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public void insert(Invoice invoice) {

		String insertQuery = "insert into invoice (order_id,Delivery_date,user_id) values (?,sysdate+?,?)";

		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
//			System.out.println(pro.getProductName() + pro.getQuantity() + pro.getUnitPrice());

			
			pstmt.setInt(1 ,invoice.getOrderId());
			pstmt.setInt(2, invoice.getDeliveryDate());
			pstmt.setInt(3, invoice.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "inserted");
			pstmt.close();
			con.close();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	public ResultSet showUserInvoice(int userid) {
		String userinvoice = "select * from invoice  where user_id=?";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt= con.prepareStatement(userinvoice);

			pstmt.setInt(1, userid);
			
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	
	
	
	
	
	
	
	}
