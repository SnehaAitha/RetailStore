package com.example.service;

import com.example.domain.Order;
import com.example.domain.User;
public interface UserService {
    User findUserForOrder(Long id);
    Order findOrderById(Long id);
}
