package com.stock.dao;

import java.sql.ResultSet;

import com.stock.model.Stock;

public interface StockDao {
	public ResultSet showProduct();
	public void insert(Stock pro);
	public void Adminupdated(Stock pro1);
	public void updateQuantity(int proid,int qty);
	public void delete(Stock pro2);
	public ResultSet validateProduct(String proName);
	public Stock validateProductId(int productId);
	
}
