package com.onlineshopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshopping.dao.UserDAO;
import com.onlineshopping.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;

	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;

	}

	public boolean deleteUser(int u_id) {
		sessionFactory.getCurrentSession().delete(getUserById(u_id));
		return true;
	}

	public User getUserById(int u_id) {
		return sessionFactory.getCurrentSession().get(User.class, u_id);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getUserByUsername(String username) {
		return sessionFactory.getCurrentSession().createQuery("from User where name=:username", User.class)
				.setParameter("username", username).getSingleResult();
	}

}
