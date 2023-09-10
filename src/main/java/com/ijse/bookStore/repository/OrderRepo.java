package com.ijse.bookStore.repository;

import org.springframework.stereotype.Repository;

import com.ijse.bookStore.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
    
}
