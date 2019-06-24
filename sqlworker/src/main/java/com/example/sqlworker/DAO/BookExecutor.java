package com.example.sqlworker.DAO;

import com.example.sqlworker.model.Book;
import com.example.sqlworker.model.Bookl;
import com.example.sqlworker.rabbit.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookExecutor implements Runnable{

    private Bookl bookl;
    RabbitSender rabbitSender;
    BookRepositoryImpl bookRepositoryImpl;


    public BookExecutor(Bookl bookl, RabbitSender rabbitSender, BookRepositoryImpl bookRepositoryImpl) {
        this.bookl = bookl;
        this.rabbitSender = rabbitSender;
        this.bookRepositoryImpl = bookRepositoryImpl;
    }


    @Override
    public void run() {
        execute(bookl);
    }

    private void execute(Bookl bookl){
        String method = bookl.getMethod();
        switch (method){
            case "bookByIsn":{
                Book book = bookRepositoryImpl.bookByIsn(bookl.getIsn());
                bookl.setIsn(book.getIsn());
                bookl.setTitle(book.getTitle());
                bookl.setPublished(book.getPublished());
                bookl.setPublisher(book.getPublisher());
                bookl.setAuthors(book.getAuthors());
                break;

            }
            case "books":{
                bookl.setBookList(bookRepositoryImpl.books());
                break;
            }
            case "bookByTitle":{
                bookl.setBookList(bookRepositoryImpl.bookByTitle(bookl.getTitle()));
                break;
            }

            case "bookByPublisher":{
                bookl.setBookList(bookRepositoryImpl.bookByPublisher(bookl.getPublisher()));
                break;
            }

            case "newBook":{
                Book book = bookRepositoryImpl.newBook(new Book(bookl.getIsn(), bookl.getTitle(),
                        bookl.getPublisher(), bookl.getAuthors(), bookl.getPublished()));
                bookl.setIsn(book.getIsn());
                bookl.setTitle(book.getTitle());
                bookl.setPublished(book.getPublished());
                bookl.setPublisher(book.getPublisher());
                bookl.setAuthors(book.getAuthors());
                break;

            }
        }

        rabbitSender.send("info2", bookl);


    }
}
