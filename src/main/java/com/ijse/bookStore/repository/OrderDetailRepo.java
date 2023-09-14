package com.ijse.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ijse.bookStore.entity.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail,Long>{
    
}
