package com.stock.dao;

import java.sql.ResultSet;
import java.util.List;

import com.stock.model.Purchase;

public interface PurchaseDao {

	
	public int insert(Purchase purchase);
	public void updated(Purchase purchase1 );
	public void delete(Purchase  purchase2);
	
	public List<Purchase> viewpurchase();
}
