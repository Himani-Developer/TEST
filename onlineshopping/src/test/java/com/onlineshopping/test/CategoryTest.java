package com.onlineshopping.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.CategoryDAO;
import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.model.Category;
import com.onlineshopping.model.Product;

public class CategoryTest {
	
	private static AnnotationConfigApplicationContext context=null;
	private static CategoryDAO categoryDAO=null;
	private Category category=null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
	
	}
	
	@Ignore
	@Test
	public void testAddCategory() {
		category=new Category();
		category.setCategoryname("purse");
		category.setCategorydesc("affordable");
		System.out.println("Category details added");
		assertTrue("could not save the category details", categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void testUpdateCategory() {
		category=new Category();
		category.setCategoryid(0);
		category.setCategoryname("Clutch");
		category.setCategorydesc("Hold on");
		System.out.println("Category details updated");
		assertTrue("could not update the category details", categoryDAO.updateCategory(category));
		
	}
	@Ignore
	@Test
	public void testDeleteCategory() {
	assertTrue("could not delete the details", categoryDAO.deleteCategory(2));	
	}
	
	
@Ignore
	@Test
	public void testListCategory() {
		List<Category> listCategories=categoryDAO.getAll();
		assertTrue("could not list category", listCategories.size()>0);
		for(Category category:listCategories) {
			System.out.print(category.getCategoryid()+"::");
			System.out.print(category.getCategoryname()+"::");
			System.out.println(category.getCategorydesc()+"::");
			
		}
			
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
