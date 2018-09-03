package com.onlineshopping.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table
public class Product {
	@Id
	@GeneratedValue
	int productid;
	String productname;
	String productbrandname;
	String productcolor;
	String productmaterial;
	String productdetails;
	int price;
	int stock;
	int categoryid;
	int supid;
	
	@Transient
	private MultipartFile file;
	private String code;
	
	// constructor
	public Product() {
		
		this.code="PRD"+UUID.randomUUID().toString().substring(26).toUpperCase(); // THIS WILL GENERATE AUTOMATIC IDS
	}
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductbrandname() {
		return productbrandname;
	}
	public void setProductbrandname(String productbrandname) {
		this.productbrandname = productbrandname;
	}
	public String getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}
	public String getProductmaterial() {
		return productmaterial;
	}
	public void setProductmaterial(String productmaterial) {
		this.productmaterial = productmaterial;
	}
	public String getProductdetails() {
		return productdetails;
	}
	public void setProductdetails(String productdetails) {
		this.productdetails = productdetails;
	}
	
	
	

}
