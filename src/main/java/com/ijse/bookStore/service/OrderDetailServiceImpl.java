package com.ijse.bookStore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.OrderDetail;
import com.ijse.bookStore.repository.OrderDetailRepo;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    
    @Autowired
    OrderDetailRepo orderDetailRepository;

    @Override
    public  List<OrderDetail> getAllOrderDetails(){
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(Long id){
        return orderDetailRepository.findById(id).orElseThrow(() -> new NoSuchElementException("OrderDetails Not found for" + id));
    }

    @Override
    public  OrderDetail createOrderDetail(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail){
        OrderDetail existingOrderDetail = getOrderDetailById(id);

        existingOrderDetail.setQuantity(orderDetail.getQuantity());
        existingOrderDetail.setSubTotal(orderDetail.getSubTotal());

        return orderDetailRepository.save(existingOrderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id){
        orderDetailRepository.deleteById(id);
    }
}
