package com.example.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.domain.Order;
import com.example.domain.Product;
import com.example.domain.User;
import com.example.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private static List<User> users;
	static {
		try {
			users = populateUsers();
		} catch (Exception e) {
			logger.debug("Exception in populating users");
		}
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findUserForOrder(Long id) {
		User userForOrder = null;
		for (User user : findAllUsers()) {
			if (user.getOrder().getOrderId() == id) {
				userForOrder = user;
			}
		}
		return userForOrder;
	}

	public List<Order> findAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		for (User user : findAllUsers()) {
			orders.add(user.getOrder());
		}
		return orders;
	}

	public Order findOrderById(Long id) {
		Order orderById = null;
		for (Order order : findAllOrders()) {
			if (order.getOrderId() == id) {
				orderById = order;
			}
		}
		return orderById;
	}

	private static List<User> populateUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		List<Product> productList1 = new ArrayList<Product>();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		productList1.add(new Product(1L, "sample", 100, "Grocery", 1));
		productList1.add(new Product(2L, "sample1", 500, "Home Decors", 1));
		productList1.add(new Product(3L, "sample2", 200, "Kitchenware", 2));
		users.add(new User(1L, "Sneha Aitha", simpleDateFormat.parse("2013-09-09"), "Employee",
				new Order(1L, simpleDateFormat.parse("2018-09-09"), productList1)));
		List<Product> productList2 = new ArrayList<Product>();
		productList2.add(new Product(4L, "sample3", 800, "Kitchenware", 1));
		productList2.add(new Product(5L, "sample4", 1500, "Home Decors", 1));
		productList2.add(new Product(6L, "sample5", 500, "Grocery", 1));
		users.add(new User(2L, "Sushma Aitha", simpleDateFormat.parse("2011-09-09"), "Affiliate",
				new Order(2L, simpleDateFormat.parse("2016-09-09"), productList2)));
		List<Product> productList3 = new ArrayList<Product>();
		productList3.add(new Product(7L, "sample6", 290, "Grocery", 2));
		productList3.add(new Product(8L, "sample7", 150, "Kitchenware", 1));
		productList3.add(new Product(9L, "sample8", 986, "Home Decors", 1));
		users.add(new User(3L, "Krishna Aitha", simpleDateFormat.parse("2016-09-09"), "General",
				new Order(3L, simpleDateFormat.parse("2018-09-09"), productList3)));
		List<Product> productList4 = new ArrayList<Product>();
		productList4.add(new Product(10L, "sample9", 100, "Home Decors", 1));
		productList4.add(new Product(11L, "sample10", 400, "Kitchenware", 2));
		productList4.add(new Product(12L, "sample11", 100, "Grocery", 1));
		users.add(new User(4L, "AVR Aitha", simpleDateFormat.parse("2017-05-21"), "General",
				new Order(4L, simpleDateFormat.parse("2019-05-26"), productList4)));
		return users;
	}
}