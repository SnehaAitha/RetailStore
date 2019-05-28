package com.example.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.Order;
import com.example.domain.Product;
import com.example.domain.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class BillController {
	public static final Logger logger = LoggerFactory.getLogger(BillController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/bill/{orderId}", method = RequestMethod.GET)
	public double calculateTotalBill(@PathVariable("orderId") Long id) {

		User user = null;
		Order order = null;
		double orderTotal = 0;
		double totalForDiscount = 0;
		double finalBillAmount = 0;
		List<Product> productList = null;
		user = userService.findUserForOrder(id);
		order = userService.findOrderById(id);
		Long differnceInTime =  order.getOrderDate().getTime() - user.getUserRegistrationDate().getTime();
		Long years = (differnceInTime / (1000l * 60 * 60 * 24 * 365));
		productList = user.getOrder().getProductList();
		for (Product product : productList) {
			orderTotal = orderTotal + (product.getQuantity() * product.getRate());
			if (!product.getProductCategory().equalsIgnoreCase("Grocery"))
				totalForDiscount = totalForDiscount + (product.getQuantity() * product.getRate());
		}
		if (user.getUserCategory().equalsIgnoreCase("Employee"))
			orderTotal = orderTotal - ((30 * totalForDiscount) / 100);
		else if (user.getUserCategory().equalsIgnoreCase("Affiliate"))
			orderTotal = orderTotal - ((10 * totalForDiscount) / 100);
		else if (user.getUserCategory().equalsIgnoreCase("General") && years >= 2)
			orderTotal = orderTotal - ((5 * totalForDiscount) / 100);
		finalBillAmount = orderTotal - (5 * (orderTotal / 100));
		return finalBillAmount;
	}
}