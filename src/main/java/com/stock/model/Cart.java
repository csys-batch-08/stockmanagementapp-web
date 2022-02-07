package com.stock.model;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable{
private int cartId;
private int userId;
private int productId;
private int qunatity;
private double totalPrice;
private Date expectedDate;
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getQunatity() {
	return qunatity;
}
public void setQunatity(int qunatity) {
	this.qunatity = qunatity;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public Date getExpectedDate() {
	return expectedDate;
}
public void setExpectedDate(Date expectedDate) {
	this.expectedDate = expectedDate;
}
public Cart(int cartId, int userId, int productId, int qunatity, double totalPrice, Date expectedDate) {
	super();
	this.cartId = cartId;
	this.userId = userId;
	this.productId = productId;
	this.qunatity = qunatity;
	this.totalPrice = totalPrice;
	this.expectedDate = expectedDate;
}
public Cart(int userId, int productId, int qunatity, double totalPrice, Date expectedDate) {
	super();
	this.userId = userId;
	this.productId = productId;
	this.qunatity = qunatity;
	this.totalPrice = totalPrice;
	this.expectedDate = expectedDate;
}
public Cart(int productId , int userId) {
	super();
	this.userId = userId;
	this.productId = productId;
}




	
	
	
	
	
	
}
