package com.ijse.bookStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order foodOrder);
    Order updateOrder(Long id, Order foodOrder);
    void deleteOrder(Long id);
}
