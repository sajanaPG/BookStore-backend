package com.ijse.bookStore.repository;



import com.ijse.bookStore.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepo extends JpaRepository<Order, Long>{
    
}
