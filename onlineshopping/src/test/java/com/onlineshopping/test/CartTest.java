package com.onlineshopping.test;

import static org.junit.Assert.*;


import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.CartDAO;
import com.onlineshopping.model.CartItem;

public class CartTest {

	private static AnnotationConfigApplicationContext context=null;
	private static CartDAO cartDAO=null;
	private CartItem cartItem=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		cartDAO=(CartDAO) context.getBean("cartDAO");
		
	}
	
@Ignore
	@Test
	public void testAddCart() {
		cartItem=new CartItem();
		cartItem.setProductid(14);
		cartItem.setProductname("Lavie");
		cartItem.setQuantity(34);
		cartItem.setName("himani");
		cartItem.setPrice(8000);
		cartItem.setStatus("NA");
		
		assertTrue("Could not save the cart details", cartDAO.addCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void showCartItems() {
		List<CartItem> listCartItems=cartDAO.getAll("Ankita");
		assertTrue("could not show the details of cart", listCartItems.size()>0);
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProductname()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.print(cartItem.getPrice()+":::");
			System.out.println(cartItem.getStatus()+":::");
			
		}
	}
	
	@Ignore
	@Test
	public void getCartItemTestCase() {
		CartItem cartItem=cartDAO.getCartItem(139);
		
		assertNotNull("COULD NOT GET THE CARTITEMS", cartItem);
		System.out.println("-------------Getting a CartItem----------");
		System.out.print(cartItem.getProductname()+":::");
		System.out.print(cartItem.getQuantity()+":::");
		System.out.print(cartItem.getPrice()+":::");
		System.out.println(cartItem.getStatus()+":::");
		
	}
	
	@Ignore
	@Test
	public void testdeleteCartItem() {
		CartItem cartItem=cartDAO.getCartItem(140);
		assertTrue("Could not delete cart details", cartDAO.deleteCartItem(cartItem));
	}
	
	
}
