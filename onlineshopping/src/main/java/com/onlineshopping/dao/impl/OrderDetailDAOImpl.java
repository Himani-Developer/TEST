package com.onlineshopping.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshopping.dao.OrderDetailDAO;
import com.onlineshopping.model.OrderDetail;

@Repository("OrderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	SessionFactory sessionFatory;
	
	
	public boolean addOrderDetail(OrderDetail orderDetail) {
		try {
			sessionFatory.getCurrentSession().save(orderDetail);
		return true;
		}
		catch(Exception e){
			return false;
		}
		
		}
	
	public boolean updateOrderDetail(String name) {
		try {
			Session session=sessionFatory.getCurrentSession();
			Query query=session.createQuery("update CartItem set status='P' where name=:myusername and status='NA'");
			query.setParameter("myusername", name);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
				return true;
			else 
				return false;
		
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		}

}
