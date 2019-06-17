package com.example.graphqlresolver.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import com.example.graphqlresolver.rabbit.RabbitSender;
import com.example.graphqlresolver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RabbitSender rabbitSender;

    public Book newBook(Book book){
        Bookl bookl = new Bookl("newBook");
        bookl.setIsn(book.getIsn());
        bookl.setTitle(book.getTitle());
        bookl.setAuthors(book.getAuthors());
        bookl.setPublisher(book.getPublisher());
        book.setPublished(book.getPublished());
        rabbitSender.send("info", bookl);
        return bookRepository.saveAndFlush(book);
    }
}
