package com.onlineshopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshopping.dao.CategoryDAO;
import com.onlineshopping.model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
		return true;
		
	
	}

	public boolean updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return true;
	}

	public boolean deleteCategory(int categoryid) {
		sessionFactory.getCurrentSession().delete(getCategoryById(categoryid));
		return true;
	}

	public Category getCategoryById(int categoryid) {
		return sessionFactory.getCurrentSession().get(Category.class, categoryid);
	}

	public List<Category> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	
	

}
