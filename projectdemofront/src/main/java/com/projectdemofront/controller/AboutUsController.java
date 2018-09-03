package com.projectdemofront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {

	@RequestMapping(value="/aboutus")
	public String showAboutUs(Model model)
	{ 
    model.addAttribute("UserClickedAboutus", "true");
		return "aboutus";
		
		
	}
}
