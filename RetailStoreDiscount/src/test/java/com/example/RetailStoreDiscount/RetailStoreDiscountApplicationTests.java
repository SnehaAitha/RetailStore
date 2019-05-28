package com.example.RetailStoreDiscount;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.domain.Order;
import com.example.domain.User;
import com.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailStoreDiscountApplicationTests {
	
	@Autowired
	UserService userService;

	@Test
	public void findUserForOrder() {
		User user = userService.findUserForOrder(3L);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void findOrderById() {
		Order order = userService.findOrderById(3L);
		Assert.assertNotNull(order);
	}

}
