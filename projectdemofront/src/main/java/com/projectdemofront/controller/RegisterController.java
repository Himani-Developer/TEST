package com.projectdemofront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshopping.dao.UserDAO;
import com.onlineshopping.model.User;

@Controller
public class RegisterController {
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value="/register")
	public String showRegister(Model model) {
	
		model.addAttribute("UserClickedRegister", "true");
		model.addAttribute("user", new User());
		model.addAttribute("userlist", userDAO.getAll());
		model.addAttribute("url", "Saveuser");
		
		return "register";
	}
	
	
	
	@RequestMapping(value="/Saveuser",method=RequestMethod.POST)
	public String saveRegister(@ModelAttribute("user")User user) {
		
		userDAO.addUser(user);
		return "redirect:/register";
	}
	
	
	@RequestMapping(value="/Updateuser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user")User user) {
		
		userDAO.updateUser(user);
		return "redirect:/register";
		
	}
		
	
	
	@RequestMapping(value="/edituser/{u_id}")
	public String editUser(@PathVariable("u_id")int u_id,Model model) {
		
		model.addAttribute("UserClickedEdit", "true");
		model.addAttribute("user", userDAO.getUserById(u_id));
		model.addAttribute("url", "Updateuser");
		model.addAttribute("userlist", userDAO.getAll());
		return "register";
	}
	
	
	
	@RequestMapping(value="/deleteuser/{u_id}")
	public String deleteUser(@PathVariable("u_id")int u_id,Model model) {
		
		model.addAttribute("user", userDAO.getUserById(u_id));
		userDAO.deleteUser(u_id);
		model.addAttribute("userlist", userDAO.getAll());
		return "register";
	}
	
	
	
}
