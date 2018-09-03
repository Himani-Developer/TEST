package com.onlineshopping.dao;

import java.util.List;

import com.onlineshopping.model.CartItem;

public interface CartDAO {
	
	public boolean addCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public List<CartItem> getAll(String name);
	public CartItem getCartItem(int cartItemId);
	
}
