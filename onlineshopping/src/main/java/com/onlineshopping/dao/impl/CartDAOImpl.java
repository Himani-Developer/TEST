package com.onlineshopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshopping.dao.CartDAO;
import com.onlineshopping.model.CartItem;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean addCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
		  return true;
		}
		catch(Exception e)
		{
			return false;
			
			
		}
		
		
	}

	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
		  return true;
		}
		catch(Exception e)
		{
			return false;
			
			
		}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
		  return true;
		}
		catch(Exception e)
		{
			return false;
			
			
		}
	}

	

	public CartItem getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.close();
		return cartItem;
	}

	public List<CartItem> getAll(String name) {
		return sessionFactory.getCurrentSession().createQuery("from CartItem where status='NA' and name=:name").setParameter("name", name).list();
	}

}
