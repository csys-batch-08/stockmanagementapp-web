package com.stock.dao;


import java.util.List;

import com.stock.model.Cart;

public interface CartDao   {

	public void insert(Cart cart);
	public List<Cart> allcart(int userid);
	public void delete(Cart cart);
	
	
	
}
