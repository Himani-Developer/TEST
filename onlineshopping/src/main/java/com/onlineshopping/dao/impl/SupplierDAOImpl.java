package com.onlineshopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshopping.dao.SupplierDAO;
import com.onlineshopping.model.Supplier;


@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	}

	public boolean updateSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	}

	public boolean deleteSupplier(int supid) {
		sessionFactory.getCurrentSession().delete(getSupplierById(supid));		
		return true;
	}

	public Supplier getSupplierById(int supid) {
		
		return sessionFactory.getCurrentSession().get(Supplier.class, supid);
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

}
