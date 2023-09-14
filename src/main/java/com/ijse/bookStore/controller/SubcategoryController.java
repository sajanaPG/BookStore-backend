package com.ijse.bookStore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookStore.entity.Subcategory;
import com.ijse.bookStore.service.SubcategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class SubcategoryController {
    
    @Autowired
    SubcategoryService subcategoryService;

    @GetMapping("/subcategory")
    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
        return ResponseEntity.status(HttpStatus.OK).body(subcategoryService.getAllSubcategories());
    }

    @GetMapping("/subcategory/{id}")
    public ResponseEntity<Subcategory> getSubcategoryById(@PathVariable Long id) {
        try {
            Subcategory subcategory = subcategoryService.getSubcategoryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(subcategory);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/admin/subcategory")
    public ResponseEntity<Subcategory> saveSubcategory(@RequestBody Subcategory subcategory) {
        try {
            Subcategory subcategoryCreated = subcategoryService.createSubcategory(subcategory);
            return ResponseEntity.status(HttpStatus.CREATED).body(subcategoryCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/admin/subcategory/{id}")
    public ResponseEntity<Subcategory> updateSubcategory(@PathVariable Long id, @RequestBody Subcategory subcategory) {

        try {
            Subcategory updatedSubcategory = subcategoryService.updateSubcategory(id, subcategory);
            return ResponseEntity.status(HttpStatus.OK).body(updatedSubcategory);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/admin/subcategory/{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable Long id) {
        try {
            subcategoryService.deleteSubcategory(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/category/{categoryId}/subcategory")
    public ResponseEntity<List<Subcategory>> getSubByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(subcategoryService.getSubByCategoryId(categoryId)); 
    }
}
