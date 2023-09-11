package com.ijse.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.bookStore.entity.OrderDetail;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail,Long>{
    
}
