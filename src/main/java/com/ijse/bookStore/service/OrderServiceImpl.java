package com.ijse.bookStore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Order;
import com.ijse.bookStore.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    OrderRepo OrderRepository;

    @Override
    public List<Order> getAllOrders() {
        return OrderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return OrderRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Order createOrder(Order Order) {
        return OrderRepository.save(Order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);

        existingOrder.setAddress(order.getAddress());
        existingOrder.setTotal(order.getTotal());
        existingOrder.setStatus(order.getStatus());
        return OrderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        OrderRepository.deleteById(id);
    }
}
