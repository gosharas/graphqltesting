package com.example.sqlworker.repository;

import com.example.sqlworker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
