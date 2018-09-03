package com.onlineshopping.dao;
import java.util.List;

import com.onlineshopping.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int u_id);
	public User getUserById(int u_id);
	public List<User> getAll();
	public User getUserByUsername(String username);
	
	

}
