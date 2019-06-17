package com.example.graphqlresolver.service;

import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import com.example.graphqlresolver.rabbit.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GraphService {

    @Autowired
    private Map<String, Book> receiveMap;

    @Autowired
    private Map<String, List<Book>> receiveMapList;

    @Autowired
    RabbitSender rabbitSender;

    public List<Book> books(){
        String reqId = UUID.randomUUID().toString();
        Bookl bookl = new Bookl("books");
        bookl.setReqId(reqId);
        rabbitSender.send("info", bookl);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<Book> list = receiveMapList.get(reqId);
        return list;
    }

    public Book bookByIsn(String isn){
        String reqId = UUID.randomUUID().toString();
        Bookl bookl = new Bookl("bookByIsn");
        bookl.setIsn(isn);
        bookl.setReqId(reqId);
        rabbitSender.send("info", bookl);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Book book = receiveMap.get(reqId);
        return book;
    }

    public List<Book> bookByTitle(String title){
        String reqId = UUID.randomUUID().toString();
        Bookl bookl = new Bookl("bookByTitle");
        bookl.setTitle(title);
        bookl.setReqId(reqId);
        rabbitSender.send("info", bookl);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<Book> list = receiveMapList.get(reqId);

        return list;
    }

    public List<Book> bookByPublisher(String publisher){
        String reqId = UUID.randomUUID().toString();
        Bookl bookl = new Bookl("bookByPublisher");
        bookl.setPublisher(publisher);
        bookl.setReqId(reqId);
        rabbitSender.send("info", bookl);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<Book> list = receiveMapList.get(reqId);
        return list;
    }

    public Book newBook(Book book){
        return null;
    }
}
