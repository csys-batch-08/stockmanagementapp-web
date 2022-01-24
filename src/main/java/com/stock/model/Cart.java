package com.stock.model;

import java.util.Date;

public class Cart {
private int cartid;
private int userId;
private int productId;
private int qunatity;
private double totalPrice;
private int expectedDate;

public int getCart() {
	return cartid;
}
public void setCart(int cart) {
	this.cartid = cart;
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
public int getExpectedDate() {
	return expectedDate;
}
public void setExpectedDate(int expectedDate) {
	this.expectedDate = expectedDate;
}
@Override
public String toString() {
	return "Cart [cart=" + cartid + ", userId=" + userId + ", productId=" + productId + ", qunatity=" + qunatity
			+ ", totalPrice=" + totalPrice + ", expectedDate=" + expectedDate + "]";
}
public Cart(int cartid, int userid, int productId, int quantity, int totalPrice, int date) {
	
	// TODO Auto-generated constructor stub
	this.cartid=cartid;
	this.userId = userid;
	this.productId = productId;
	this.qunatity = quantity;
	this.totalPrice = totalPrice;
	this.expectedDate = date;
}
public Cart(int userId, int productId, int qunatity, double totalPrice, int expectedDate) {
	super();
	this.userId = userId;
	this.productId = productId;
	this.qunatity = qunatity;
	this.totalPrice = totalPrice;
	this.expectedDate = expectedDate;
}
public Cart(int productId,int userId) {
	super();
	this.userId = userId;
	this.productId = productId;
}




	
	
	
	
	
	
}
