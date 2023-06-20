package com.example.kiii182006.service;

import com.example.kiii182006.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void save(Book book);
    Book getById(Long id);
    void deleteById(Long id);
}
