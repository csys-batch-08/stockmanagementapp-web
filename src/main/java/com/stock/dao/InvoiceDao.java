package com.stock.dao;


import java.util.List;

import com.stock.model.Invoice;

public interface InvoiceDao {

	public List<Invoice> showInvoice();
	public void insert(Invoice invoice);
	
	
}
