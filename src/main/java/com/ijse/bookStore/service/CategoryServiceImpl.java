package com.ijse.bookStore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Category;
import com.ijse.bookStore.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    CategoryRepo categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Category createCategory(Category Category) {
        return categoryRepository.save(Category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
