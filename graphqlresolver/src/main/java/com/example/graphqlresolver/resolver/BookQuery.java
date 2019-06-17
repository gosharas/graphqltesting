package com.example.graphqlresolver.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import com.example.graphqlresolver.rabbit.RabbitSender;
import com.example.graphqlresolver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RabbitSender rabbitSender;

    public List<Book> books(){
        return bookRepository.findAll();
    }

    public Book bookByIsn(String isn){
//        Bookl bookl = new Bookl();
//        bookl.setIsn("1");
//        bookl.setAuthors("auth1");
//        bookl.setPublished("publed1");
        Book book = bookRepository.findBookByIsn(isn);
        rabbitSender.send("info", book);
        return book;
    }

    public List<Book> bookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public List<Book> bookByPublisher(String publisher){
        return  bookRepository.findBookByPublisher(publisher);
    }
}
