package com.example.graphqlresolver.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import com.example.graphqlresolver.rabbit.RabbitSender;
import com.example.graphqlresolver.repository.BookRepository;
import com.example.graphqlresolver.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    GraphService graphService;

    public Book newBook(Book book){
        return graphService.newBook(book);
    }
}
