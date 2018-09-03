package com.onlineshopping.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetail")
public class OrderDetail {

	@Id
	@GeneratedValue
	int orderId;
	
	String name;
	Date orderDate;
	int totalPurchasedAmount;
	String paymentMode;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalPurchasedAmount() {
		return totalPurchasedAmount;
	}
	public void setTotalPurchasedAmount(int totalPurchasedAmount) {
		this.totalPurchasedAmount = totalPurchasedAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	
}
