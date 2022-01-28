package com.stock.model;

import java.util.Date;

public class Invoice {

	private int billId;
	private int orderId;
	private String status;
	private Date deliveryDate;
	private int userId;
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Invoice(int orderId, Date deliveryDate, int userId) {
		super();
		this.orderId = orderId;
		this.deliveryDate = deliveryDate;
		this.userId = userId;
	}
	public Invoice(int billId, int orderId, String status, Date deliveryDate, int userId) {
		super();
		this.billId = billId;
		this.orderId = orderId;
		this.status = status;
		this.deliveryDate = deliveryDate;
		this.userId = userId;
	}
	
	
	
	
}
