package com.onlineshopping.dao;

import java.util.List;

import com.onlineshopping.model.Supplier;

public interface SupplierDAO {
	
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supid);
	public Supplier getSupplierById(int supid);
	public List<Supplier> getAll();
	

}
