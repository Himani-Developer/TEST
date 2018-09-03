package com.projectdemofront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactUsController {

	@RequestMapping(value="/contactus")
	public String showContactus(Model model) {
		model.addAttribute("UserClickedContactus", "true");
		return "contactus";
		
	}
}
