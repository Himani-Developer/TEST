package com.projectdemofront.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineshopping.dao.CartDAO;
import com.onlineshopping.dao.OrderDetailDAO;
import com.onlineshopping.dao.UserDAO;
import com.onlineshopping.model.CartItem;
import com.onlineshopping.model.OrderDetail;
import com.onlineshopping.model.User;

@Controller
public class OrderController {

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/checkout")
	public String checkOutProcess(Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		if(username==null) {
			return "redirect:/login";
		}
      List<CartItem> cartItems=cartDAO.getAll(username);
		
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalPurchasedAmount", this.calcTotalPurchasedAmount(cartItems));
		
		return "MyOrder";
	}
	
	
	@RequestMapping("/payment")
	public String paymentProcess(Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		 List<CartItem> cartItems=cartDAO.getAll(username);
		 model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalPurchasedAmount", this.calcTotalPurchasedAmount(cartItems));
		
		
		
		return "Payment";
		
	}
	
	
	@RequestMapping(value="/paymentProcess",method=RequestMethod.POST)
	public String paymentProcessing(@RequestParam("paymenttype") String paymentmode, Model model, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<CartItem> cartItems=cartDAO.getAll(username);
		model.addAttribute("cartItems", cartItems);
		int totalPurchasedAmount=this.calcTotalPurchasedAmount(cartItems);
		model.addAttribute("totalPurchasedAmount", totalPurchasedAmount);
		
			
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setName(username);
		orderDetail.setPaymentMode(paymentmode);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setTotalPurchasedAmount(totalPurchasedAmount);
		User user=userDAO.getUserByUsername(username);
		model.addAttribute("user", user);
		orderDetailDAO.addOrderDetail(orderDetail);
	orderDetailDAO.updateOrderDetail(username);
		
		model.addAttribute("orderDetail", orderDetail);
		return "Receipt";
	}
	
	
	public int calcTotalPurchasedAmount(List<CartItem> cartItems)
	{
		int totalPurchasedAmount=0;
		int count=0;
		
		while(count<cartItems.size())
		{
			CartItem cartItem=cartItems.get(count);
			totalPurchasedAmount=totalPurchasedAmount+(cartItem.getQuantity() * cartItem.getPrice());
			count++;
		}
		
		return totalPurchasedAmount;
		
	}	
}
