package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock.model.Stock;
import com.stock.dao.InvoiceDao;
import com.stock.model.Cart;
import com.stock.model.Invoice;
import com.stock.util.ConnectionUtil;

public class InvoiceImpl implements InvoiceDao {

	
	
	public List<Invoice> showInvoice() {
		
		List<Invoice> admininvoice=new ArrayList<Invoice>();
		String invoiceQuery = "select bill_id,order_id,status,delivery_date,user_id from invoice";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(invoiceQuery);
			while(rs.next()){
				
				Invoice invoice=new Invoice(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),rs.getInt(5));
				
				admininvoice.add(invoice);
		
		
		} }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admininvoice;
	}
	public void insert(Invoice invoice) {

		String insertQuery = "insert into invoice (order_id,Delivery_date,user_id) values (?,?,?)";

		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
//			System.out.println(pro.getProductName() + pro.getQuantity() + pro.getUnitPrice());

			
			pstmt.setInt(1 ,invoice.getOrderId());
			pstmt.setDate(2,new java.sql.Date(invoice.getDeliveryDate().getTime()));
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
	

	public List<Invoice> showUserInvoice(int userid) {
		List<Invoice> userinvoiceview=new ArrayList<Invoice>();
		String userinvoice = "select bill_id,order_id,status,delivery_date,user_id from invoice  where user_id=?";
		Connection con;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt= con.prepareStatement(userinvoice);

			pstmt.setInt(1, userid);
			
			rs = pstmt.executeQuery();
while(rs.next()){
				
				Invoice invoice=new Invoice(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),rs.getInt(5));
				
				userinvoiceview.add(invoice);
		
		
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userinvoiceview;
	}

	
	
	
	
	
	
	
	}
