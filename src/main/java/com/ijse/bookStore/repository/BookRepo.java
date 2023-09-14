package com.ijse.bookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ijse.bookStore.entity.Book;

public interface BookRepo extends JpaRepository<Book,Long> {
    @Query("SELECT book FROM Book book WHERE book.subcategory.id= :subcategoryId")
    List<Book> findbooksBySubcategoryId(@Param("subcategoryId") Long subcategoryId);
}
