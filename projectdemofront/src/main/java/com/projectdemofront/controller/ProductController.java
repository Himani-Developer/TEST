package com.projectdemofront.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshopping.dao.CategoryDAO;
import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping("/ShowAllProduct")
	public String showProduct(Model model) {
		model.addAttribute("product",new Product());	//Product product=new Product();    //
		model.addAttribute("productlist", productDAO.getAll());   //model.addAttribute(product);    // 
		model.addAttribute("url","Saveproduct");
		model.addAttribute("catlist", categoryDAO.getAll());
		return "addproduct";
	}
	
	@RequestMapping("/productDisplay")
	public String displayAllProducts(Model model)
	{
		model.addAttribute("productlist", productDAO.getAll());
		return "ProductDisplay";
		
	}
	
	@RequestMapping("/totalProductInfo/{productid}")
	public String showTotalProductDisplay(@PathVariable("productid") int productid,Model model) {
		
		Product product=productDAO.getProductById(productid);
		model.addAttribute("product", product);
		model.addAttribute("categoryname", categoryDAO.getCategoryById(product.getCategoryid()).getCategoryname());
		return "TotalProductDisplay";
	}
	
	
	
	@RequestMapping(value="/Saveproduct",method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute("product")Product product) {
		
		if(product.getFile().isEmpty()) {
			return "redirect:/ShowAllProduct";
		}
		try {
			byte bytes[]=product.getFile().getBytes();
			String dir="C:\\Users\\Himani\\eclipse-workspace\\projectdemofront\\src\\main\\webapp\\assets\\images\\product\\";
			Path path=Paths.get(dir+product.getCode()+".jpg");
			Files.write(path, bytes);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		productDAO.addProduct(product);
		return "redirect:/ShowAllProduct";
		
	}
	
	
	@RequestMapping(value="/editproduct/{product_id}")
	public String editProduct(@PathVariable("product_id")int product_id,Model model)
	{
		
		model.addAttribute("UserClickedEdit", "true");
		model.addAttribute("product", productDAO.getProductById(product_id));
		model.addAttribute("url","Updateproduct");
		model.addAttribute("productlist", productDAO.getAll());
		return "addproduct";
		
		
	}
	
	@RequestMapping(value="/deleteproduct/{product_id}")
	public String deleteProduct(@PathVariable("product_id")int product_id,Model model) {
		
		Product product=productDAO.getProductById(product_id);
		productDAO.deleteProduct(product_id);
		model.addAttribute("product", new Product());
		model.addAttribute("productlist", productDAO.getAll());
		return "addproduct";
		
	}
	
	@RequestMapping(value="/Updateproduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product) {
		
		productDAO.updateProduct(product);
		return "redirect:/ShowAllProduct";
	}
	
	
}
