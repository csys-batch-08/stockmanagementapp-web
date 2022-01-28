package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.stock.model.Cart;

public interface CartDao   {

	public void insert(Cart cart);
	public List<Cart> allcart(int userid);
	public void delete(Cart cart);
	
	
	
}
