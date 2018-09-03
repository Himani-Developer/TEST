package com.projectdemofront.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineshopping.dao.CartDAO;
import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.model.CartItem;
import com.onlineshopping.model.Product;

@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/cart")
	public String cart(Model model,HttpSession session) {
		String username=session.getAttribute("username").toString();
		List<CartItem> cartItems = cartDAO.getAll(username);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalPurchasedAmount", this.calcTotalPurchasedAmount(cartItems));

		return "Cart";

	}

	@RequestMapping(value = "/AddToCart/{productid}")
	public String addCartItem(@RequestParam("quantity") int quantity, @PathVariable("productid") int productid,
			HttpSession session, Model model)

	{
		Product product = productDAO.getProductById(productid);
		String username = (String) session.getAttribute("username");
		
		
		CartItem cartItem = new CartItem();
		cartItem.setProductid(product.getProductid());
		cartItem.setProductname(product.getProductname());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setName(username);
		cartItem.setStatus("NA");

		cartDAO.addCartItem(cartItem);

		return "redirect:/cart";
	}

	@RequestMapping(value = "/updateCartItem/{cartItemId}")
	public String updateCartItem(@RequestParam("quantity") int quantity, @PathVariable("cartItemId") int cartItemId,
			HttpSession session, Model model) {
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		String username = (String) session.getAttribute("username");

		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);

		List<CartItem> cartItems = cartDAO.getAll(username);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalPurchasedAmount", this.calcTotalPurchasedAmount(cartItems));

		return "Cart";

	}

	@RequestMapping(value = "/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, HttpSession session, Model model) {
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		String username = (String) session.getAttribute("username");

		cartDAO.deleteCartItem(cartItem);

		List<CartItem> cartItems = cartDAO.getAll(username);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalPurchasedAmount", this.calcTotalPurchasedAmount(cartItems));

		return "Cart";

	}

	@RequestMapping(value = "/continueShopping")
	public String continueShopping(Model model) {
		model.addAttribute("productlist", productDAO.getAll());
		return "ProductDisplay";

	}

	public int calcTotalPurchasedAmount(List<CartItem> cartItems) {
		int totalPurchasedAmount = 0;
		int count = 0;

		while (count < cartItems.size()) {
			CartItem cartItem = cartItems.get(count);
			totalPurchasedAmount = totalPurchasedAmount + (cartItem.getQuantity() * cartItem.getPrice());
			count++;
		}

		return totalPurchasedAmount;

	}

}
