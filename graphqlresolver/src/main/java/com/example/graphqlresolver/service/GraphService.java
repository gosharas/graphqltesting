package com.example.graphqlresolver.service;

import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.rabbit.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphService {

    @Autowired
    RabbitSender rabbitSender;

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
