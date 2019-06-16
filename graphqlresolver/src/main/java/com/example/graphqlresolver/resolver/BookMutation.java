package com.example.graphqlresolver.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    BookRepository bookRepository;

    public Book newBook(Book book){
        return bookRepository.saveAndFlush(book);
    }
}
