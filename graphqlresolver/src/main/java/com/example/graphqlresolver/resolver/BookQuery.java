package com.example.graphqlresolver.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {

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
        return  bookRepository.findBookByPublisher(publisher);
    }
}
