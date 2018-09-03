package com.onlineshopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.model.Product;
import com.onlineshopping.model.User;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

@Autowired
SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);    //saveOrUpdate
		return true;
	}

	public boolean updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);	
		return true;
	}

	public boolean deleteProduct(int productid) {
		sessionFactory.getCurrentSession().delete(getProductById(productid));
		return true;
	}

	public Product getProductById(int productid) {
		return sessionFactory.getCurrentSession().get(Product.class, productid);
		
	}

	public List<Product> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	
}	



