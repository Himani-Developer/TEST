package com.onlineshopping.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.CORBA.ORB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.OrderDetailDAO;
import com.onlineshopping.dao.SupplierDAO;
import com.onlineshopping.model.OrderDetail;
import com.onlineshopping.model.Supplier;

public class OrderDetailTest {

	private static AnnotationConfigApplicationContext context=null;
	private static OrderDetailDAO orderDetailDAO=null;
	private OrderDetail orderDetail=null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		orderDetailDAO=(OrderDetailDAO) context.getBean("OrderDetailDAO");
		}
	
	@Ignore
	@Test
	public void addOrderDetailTest() {
		orderDetail=new OrderDetail();
		
		orderDetail.setName("akansha");
		orderDetail.setTotalPurchasedAmount(34500);
		orderDetail.setPaymentMode("CC");
	    orderDetail.setOrderDate(new java.util.Date());
	    assertTrue("could not save the order details", orderDetailDAO.addOrderDetail(orderDetail));
	}
	
	@Test
	public void updateCartItemsStatus() {
		assertTrue("Problem in updating cartitem", orderDetailDAO.updateOrderDetail("akansha"));

	}

}
