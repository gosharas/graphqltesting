package com.example.sqlworker.repository;

import com.example.sqlworker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    public Book findBookByIsn(String isn);

    public List<Book> findBookByTitle(String title);

    public List<Book> findBookByPublisher(String publisher);
}
