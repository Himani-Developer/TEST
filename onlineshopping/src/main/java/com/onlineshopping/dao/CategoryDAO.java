package com.onlineshopping.dao;

import java.util.List;

import com.onlineshopping.model.Category;

public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryid);
	public Category getCategoryById(int categoryid);
	public List<Category> getAll();

}
