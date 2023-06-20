package com.example.kiii182006.service;

import com.example.kiii182006.model.Book;
import com.example.kiii182006.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl   implements BookService{
@Autowired
private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        if(Objects.nonNull(book))
        {
            bookRepository.save(book);
        }

    }

    @Override
    public Book getById(Long id) {
        Book book = null;
       if(Objects.nonNull(id))
       {
           Optional<Book> optionalBook =  bookRepository.findById(id);

           if(optionalBook.isPresent())
           {
               book = optionalBook.get();

           }
           else
           {
               throw  new RuntimeException("Book not found with the id"+id);
           }

       }
       return book;
    }

    @Override
    public void deleteById(Long id) {
     if(Objects.nonNull(id))
     {
         bookRepository.deleteById(id);
     }
    }
}
