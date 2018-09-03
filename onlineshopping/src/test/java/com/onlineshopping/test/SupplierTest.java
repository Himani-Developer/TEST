package com.onlineshopping.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.SupplierDAO;
import com.onlineshopping.model.Supplier;


public class SupplierTest {
		private static AnnotationConfigApplicationContext context=null;
		private static SupplierDAO supplierDAO=null;
		private Supplier supplier=null;
		
		
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
	}
@Ignore
	@Test
	public void addSupplier() {
		supplier=new Supplier();
		supplier.setSupid(2003);
		supplier.setSupname("uytwe");
		supplier.setSupphone(933369760);
		supplier.setSupdetails("bad supplier");
		System.out.println("Supplier details saved");
		assertTrue("Could not save supplier details", supplierDAO.addSupplier(supplier));
			
	}
	
	
	@Ignore
	@Test
	public void updateSupplier() {
		supplier=new Supplier();
		supplier.setSupid(20001);
		supplier.setSupname("kjkd");
		supplier.setSupphone(987986786);
		supplier.setSupdetails("goood");
		System.out.println("Supplier details updated");
		assertTrue("Could not update supplier details", supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void testDeleteSupplier() {
		
		assertTrue("Could not delete user details", supplierDAO.deleteSupplier(20001));
	}
	
	
	@Ignore
	@Test
	public void testListSupplier() {
		List<Supplier> listSupplier=supplierDAO.getAll();
		assertTrue("Could not list products", listSupplier.size()>0);
		
		for(Supplier supplier:listSupplier) {
			
			System.out.print(supplier.getSupid()+"::");
			System.out.print(supplier.getSupname()+"::");
			System.out.print(supplier.getSupphone()+"::");
			System.out.println(supplier.getSupdetails()+"::");
						
			
		}
	}
	
	
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
