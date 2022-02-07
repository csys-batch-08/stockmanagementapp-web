package com.stock.dao;


import java.util.List;

import com.stock.model.Stock;

public interface StockDao {
	public List<Stock>  showProducts();
	public void insert(Stock pro);
	public void adminupdate(Stock pro1);
	public void updateQuantity(int proid,int qty);
	public void delete(Stock pro2);
	
	public Stock validateProductId(int productId);
	public List<Stock> validateProduct(String proName);
}
