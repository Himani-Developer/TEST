package com.onlineshopping.dao;

import java.util.List;

import com.onlineshopping.model.Product;


public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productid);
	public Product getProductById(int productid);
	public List<Product> getAll();
	
	
	
}
