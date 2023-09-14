package com.ijse.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.bookStore.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{
    
}
