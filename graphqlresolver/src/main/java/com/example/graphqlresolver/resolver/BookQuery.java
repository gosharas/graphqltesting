package com.example.graphqlresolver.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import com.example.graphqlresolver.rabbit.RabbitSender;
import com.example.graphqlresolver.repository.BookRepository;
import com.example.graphqlresolver.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    GraphService graphService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RabbitSender rabbitSender;

    public List<Book> books(){
        return graphService.books();
    }

    public Book bookByIsn(String isn){
        //System.out.println(graphService.bookByIsn(isn));
        return graphService.bookByIsn(isn);
    }

    public List<Book> bookByTitle(String title){
//        Bookl bookl = new Bookl("bookByTitle");
//        bookl.setTitle(title);
//        rabbitSender.send("info", bookl);
        return graphService.bookByTitle(title);
    }

    public List<Book> bookByPublisher(String publisher){
//        Bookl bookl = new Bookl("bookByPublisher");
//        bookl.setPublisher(publisher);
//        rabbitSender.send("info", bookl);
        return  graphService.bookByPublisher(publisher);
    }
}
