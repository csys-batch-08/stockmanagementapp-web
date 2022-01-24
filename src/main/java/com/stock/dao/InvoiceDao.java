package com.stock.dao;

import java.sql.ResultSet;

import com.stock.model.Invoice;

public interface InvoiceDao {

	public ResultSet showInvoice();
	public void insert(Invoice invoice);
	
	
}
