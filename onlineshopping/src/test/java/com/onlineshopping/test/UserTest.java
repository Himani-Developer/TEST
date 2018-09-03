package com.onlineshopping.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.UserDAO;

import com.onlineshopping.model.User;

public class UserTest {

	private static AnnotationConfigApplicationContext context=null;
	private static UserDAO userDAO=null;
	private User u=null;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}

	@Ignore
	@Test
	public void testAddUser() {
		u=new User();
		
		u.setName("Himani");
		u.setEmail("h@gmail.com");
		u.setPassword("himani");
		u.setPhone(890980905);
		u.setAddress("krish");
		u.setRole("user");
		u.setEnabled("true");
	
		
		System.out.println("user details saved");
		assertTrue("Could not save user details", userDAO.addUser(u));
		
	}
	
	@Ignore
	@Test
	public void testUpdateUser() {
		u=new User();
		u.setU_id(5);
		u.setName("karishma sing");
		u.setPhone(909878756);
		u.setEmail("kar@gmail.com");
		u.setPassword("abc");
		u.setAddress("krishanagr");
		u.setEnabled("false");
		u.setRole("user");
	
		assertTrue("Could not update user details", userDAO.updateUser(u));
	}
	
	
	@Ignore
	@Test
	public void testDeleteUser() {
		
		assertTrue("Could not delete user details", userDAO.deleteUser(3));
	}
	
	@Ignore
	@Test
	public void testListUser() {
		List<User> listUser=userDAO.getAll();
		assertTrue("Could not list products", listUser.size()>0);
		
		for(User user:listUser) {
			
			System.out.print(user.getU_id()+"::");
			System.out.print(user.getName()+"::");
			System.out.print(user.getEmail()+"::");
			System.out.print(user.getPassword()+"::");
			System.out.print(user.getPhone()+"::");
			System.out.print(user.getAddress()+"::");
			System.out.print(user.getEnabled()+"::");
			System.out.println(user.getRole()+"::");
			
			
		}
	}
	
	
	
@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
