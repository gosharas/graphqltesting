package com.example.sqlworker.DAO;

import com.example.sqlworker.model.Book;
import com.example.sqlworker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRepositoryImpl {

    @Autowired
    BookRepository bookRepository;

    public List<Book> books(){
        return bookRepository.findAll();
    }

    public Book bookByIsn(String isn){
        return bookRepository.findBookByIsn(isn);
    }

    public List<Book> bookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public List<Book> bookByPublisher(String publisher){
        return bookRepository.findBookByPublisher(publisher);
    }

    public Book newBook(Book book){
        return bookRepository.saveAndFlush(book);
    }
}
