package com.ijse.bookStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Subcategory;

@Service
public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();
    Subcategory getSubcategoryById(Long id);
    Subcategory createSubcategory(Subcategory subcategory);
    Subcategory updateSubcategory(Long id, Subcategory subcategory);
    void deleteSubcategory(Long id);
    List<Subcategory> getSubByCategoryId(Long categoryId);
}
