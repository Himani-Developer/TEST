package com.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	@Id
	@GeneratedValue
	int supid;
	String supname;
	String supdetails;
	int supphone;
	public int getSupid() {
		return supid;
	}
	public int getSupphone() {
		return supphone;
	}
	public void setSupphone(int supphone) {
		this.supphone = supphone;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSupdetails() {
		return supdetails;
	}
	public void setSupdetails(String supdetails) {
		this.supdetails = supdetails;
	}
	

}
