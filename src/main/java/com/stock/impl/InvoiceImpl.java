package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		try {
			con = ConnectionUtil.gbConnection();
			 stmt = con.createStatement();
			rs = stmt.executeQuery(invoiceQuery);
			while(rs.next()){
				
				Invoice invoice=new Invoice(rs.getInt("bill_id"), rs.getInt("order_id"), rs.getString("status"), rs.getDate("delivery_date"),rs.getInt("user_id"));
				
				admininvoice.add(invoice);
				
		} }catch (Exception e) {
			
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

		
		return admininvoice;
	}
	public void insert(Invoice invoice) {

		String insertQuery = "insert into invoice (order_id,Delivery_date,user_id) values (?,?,?)";
		PreparedStatement pstmt=null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(insertQuery);


			
			pstmt.setInt(1 ,invoice.getOrderId());
			pstmt.setDate(2,new java.sql.Date(invoice.getDeliveryDate().getTime()));
			pstmt.setInt(3, invoice.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "inserted");


	} catch (Exception e) {
		
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
	

	public List<Invoice> showUserInvoice(int userid) {
		List<Invoice> userinvoiceview=new ArrayList<Invoice>();
		String userinvoice = "select bill_id,order_id,status,delivery_date,user_id from invoice  where user_id=?";
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt= con.prepareStatement(userinvoice);

			pstmt.setInt(1, userid);
			
			rs = pstmt.executeQuery();
while(rs.next()){
				
				Invoice invoice=new Invoice(rs.getInt("bill_id"), rs.getInt("order_id"), rs.getString("status"), rs.getDate("delivery_date"),rs.getInt("user_id"));
				
				userinvoiceview.add(invoice);
				
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

		
		return userinvoiceview;
	}

	
	
	
	
	
	
	
	}
