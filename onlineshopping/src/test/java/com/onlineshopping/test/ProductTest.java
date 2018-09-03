package com.onlineshopping.test;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.model.Product;

public class ProductTest {
	private static AnnotationConfigApplicationContext context=null;
	private static ProductDAO productDAO=null;
	private Product product=null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		productDAO=(ProductDAO) context.getBean("productDAO");
		
	}
	
	@Ignore
	@Test
	public void testAddProduct() {
		product=new Product();
		
		product.setProductbrandname("Lavie");
		product.setProductcolor("black");
		product.setProductname("lav784");
		product.setProductmaterial("synthetic leather");
		product.setProductdetails("good");
		product.setPrice(2900);
		product.setStock(13);
		product.setSupid(1004);
		product.setCategoryid(2003);
		
		System.out.println("Product details saved");
		assertTrue("Could not save product details", productDAO.addProduct(product));
	}
	
	
	@Ignore
	@Test
	public void updateProduct() {
		product=new Product();
		product.setProductid(2);
		product.setProductcolor("purple");
		product.setProductbrandname("lavie");
		product.setProductdetails("average");
		product.setProductmaterial("synthetic leather");
		product.setProductname("lav901");
		product.setPrice(1200);
		product.setStock(2);
		product.setSupid(10023);
		product.setCategoryid(2001);
		
		System.out.println("Product detAILS update");
		assertTrue("Could not update product details", productDAO.updateProduct(product));
	}
	
	
	
	@Test
	public void testDeleteProduct() {
		
		assertTrue("Could not delete user details", productDAO.deleteProduct(2));
	}
	
	
	@Test
	public void testListProducts() {
		List<Product> listProducts=productDAO.getAll();
		assertTrue("Could not list products", listProducts.size()>0);
		
		for(Product product:listProducts) {
			
			System.out.print(product.getProductid()+"::");
			System.out.print(product.getProductbrandname()+"::");
			System.out.print(product.getProductname()+"::");
			System.out.print(product.getProductcolor()+"::");
			System.out.print(product.getProductmaterial()+"::");
			System.out.print(product.getProductdetails()+"::");
			System.out.print(product.getPrice()+"::");
			System.out.print(product.getStock()+"::");
			System.out.print(product.getSupid()+"::");
			System.out.println(product.getCategoryid()+"::");
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
