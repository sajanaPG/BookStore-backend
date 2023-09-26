package com.ijse.bookStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Book;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<Book> getBooksBySubcategoryId(Long subcategoryId);
    Book updateBookQoh(Long id, Integer quantity);
}
