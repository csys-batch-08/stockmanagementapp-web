package com.stock.dao;


import java.util.List;

import com.stock.model.Purchase;

public interface PurchaseDao {

	
	public int insert(Purchase purchase);
	
	public List<Purchase> viewpurchase();
}
