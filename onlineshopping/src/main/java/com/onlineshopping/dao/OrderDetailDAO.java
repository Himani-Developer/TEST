package com.onlineshopping.dao;

import com.onlineshopping.model.OrderDetail;

public interface  OrderDetailDAO {

	public boolean addOrderDetail(OrderDetail orderDetail);
	public boolean updateOrderDetail(String name);
}
