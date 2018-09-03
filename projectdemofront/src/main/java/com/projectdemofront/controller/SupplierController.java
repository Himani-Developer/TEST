package com.projectdemofront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshopping.dao.SupplierDAO;
import com.onlineshopping.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	
	
	@RequestMapping("/supplier")
	public String showSupplier(Model model) {
		
		model.addAttribute("UserClickedSupplier", "true");
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplist", supplierDAO.getAll() );
		model.addAttribute("url","SaveSupplier");
		
		
		return "showSuppliers";
	}
	
	//@PostMapping()
	@RequestMapping(value="/SaveSupplier",method=RequestMethod.POST)
	public String SaveSupplier(@ModelAttribute("supplier")Supplier supplier){
	
		supplierDAO.addSupplier(supplier);
		return "redirect:/supplier";
		
	}
	
	
	@RequestMapping(value="/editsupp/{suppid}")
	public String EditClicked(@PathVariable("suppid")int suppid,Model model) {
		
		model.addAttribute("UserClickedEdit", "true");
		model.addAttribute("supplier", supplierDAO.getSupplierById(suppid));
		model.addAttribute("url","UpdateSupplier");
		model.addAttribute("supplist", supplierDAO.getAll());
		return "showSuppliers";
	}
	
		
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String UpdateSupplier(@ModelAttribute("supplier")Supplier supplier) {
		System.out.println("hello");
		supplierDAO.updateSupplier(supplier);
	return "redirect:/supplier";
	
	}
	
	
	@RequestMapping(value="/deletesupp/{suppid}")
	public String deleteSupplier(@PathVariable("suppid")int suppid,Model model)
	{
		
		Supplier supplier=supplierDAO.getSupplierById(suppid);
		supplierDAO.deleteSupplier(suppid);
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplist", supplierDAO.getAll());
		return "showSuppliers";
		
			}
	
	
}
