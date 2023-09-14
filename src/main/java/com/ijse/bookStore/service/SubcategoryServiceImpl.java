package com.ijse.bookStore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Subcategory;
import com.ijse.bookStore.repository.SubcategoryRepo;

@Service
public class SubcategoryServiceImpl implements SubcategoryService{
    
    @Autowired
    SubcategoryRepo subcategoryRepository;

    @Override
    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Subcategory createSubcategory(Subcategory Subcategory) {
        return subcategoryRepository.save(Subcategory);
    }

    @Override
    public Subcategory updateSubcategory(Long id, Subcategory subcategory) {
        Subcategory existingSubcategory = getSubcategoryById(id);

        existingSubcategory.setName(subcategory.getName());
        existingSubcategory.setDescription(subcategory.getDescription());
        return subcategoryRepository.save(existingSubcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }

    @Override
    public List<Subcategory> getSubByCategoryId(Long categoryId) {
        return subcategoryRepository.findSubByCategoryId(categoryId);
    }
}
