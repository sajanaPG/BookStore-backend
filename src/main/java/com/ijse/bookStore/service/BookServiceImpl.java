package com.ijse.bookStore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.Book;
import com.ijse.bookStore.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    BookRepo bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Book createBook(Book Book) {
        return bookRepository.save(Book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setImage(book.getImage());
        existingBook.setDescription(book.getDescription());
        existingBook.setSubcategory(book.getSubcategory());
        existingBook.setQoh(book.getQoh());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksBySubcategoryId(Long subcategoryId) {
        return bookRepository.findbooksBySubcategoryId(subcategoryId);
    }

    @Override
    public Book updateBookQoh(Long id, Integer quantity) {
        Book existingBook = getBookById(id);
        existingBook.setQoh(existingBook.getQoh()-quantity);
        return bookRepository.save(existingBook);
    }
}
