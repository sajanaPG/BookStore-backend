package com.ijse.bookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ijse.bookStore.entity.Subcategory;

public interface SubcategoryRepo extends JpaRepository<Subcategory,Long> {
    @Query("SELECT subcategory FROM Subcategory subcategory WHERE subcategory.category.id= :categoryId")
    List<Subcategory> findSubByCategoryId(@Param("categoryId") Long categoryId);
}
