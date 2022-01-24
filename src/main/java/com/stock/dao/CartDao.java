package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stock.model.Cart;

public interface CartDao   {

	public void insert(Cart cart);
	public ResultSet allcart(int userid);
	public void delete(Cart cart);
	
	
	
}
