package com.example.graphqlresolver.repository;

import com.example.graphqlresolver.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    public Book findBookByIsn(String isn);

    public List<Book> findBookByTitle(String title);

    public List<Book> findBookByPublisher(String publisher);

}
