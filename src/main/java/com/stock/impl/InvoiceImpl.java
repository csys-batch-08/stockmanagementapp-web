package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;


import com.stock.dao.InvoiceDao;
import com.stock.logger.Logger;

import com.stock.model.Invoice;
import com.stock.util.ConnectionUtil;

public class InvoiceImpl implements InvoiceDao {

	public List<Invoice> showInvoice() {

		List<Invoice> admininvoice = new ArrayList<>();
		String invoiceQuery = "select bill_id,order_id,status,delivery_date,user_id from invoice order by bill_id desc";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(invoiceQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Invoice invoice = new Invoice(rs.getInt("bill_id"), rs.getInt("order_id"), rs.getString("status"),
						rs.getDate("delivery_date"), rs.getInt("user_id"));

				admininvoice.add(invoice);

			}
		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return admininvoice;
	}

	public void insert(Invoice invoice) {

		String insertQuery = "insert into invoice (order_id,Delivery_date,user_id) values (?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(insertQuery);

			pstmt.setInt(1, invoice.getOrderId());
			pstmt.setDate(2, new java.sql.Date(invoice.getDeliveryDate().getTime()));
			pstmt.setInt(3, invoice.getUserId());
		    pstmt.executeUpdate();
			

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public List<Invoice> showUserInvoice(int userid) {
		List<Invoice> userinvoiceview = new ArrayList<>();
		String userinvoice = "select bill_id,order_id,status,delivery_date,user_id from invoice  where user_id=? order by bill_id desc";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.gbConnection();
			pstmt = con.prepareStatement(userinvoice);

			pstmt.setInt(1, userid);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				Invoice invoice = new Invoice(rs.getInt("bill_id"), rs.getInt("order_id"), rs.getString("status"),
						rs.getDate("delivery_date"), rs.getInt("user_id"));

				userinvoiceview.add(invoice);

			}

		} catch (Exception e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {

			ConnectionUtil.close(rs, pstmt, con);
		}

		return userinvoiceview;
	}

}
