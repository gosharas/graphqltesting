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
        return null;
    }

    public Book bookByIsn(String isn){
        return null;
    }

    public List<Book> bookByTitle(String title){
        return null;
    }

    public List<Book> bookByPublisher(String publisher){
        return null;
    }

    public Book newBook(Book book){
        return null;
    }
}
