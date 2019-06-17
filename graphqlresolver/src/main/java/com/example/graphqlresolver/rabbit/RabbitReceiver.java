package com.example.graphqlresolver.rabbit;

import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
@EnableRabbit
public class RabbitReceiver {
    Logger logger = Logger.getLogger(String.valueOf(RabbitReceiver.class));

    @Autowired
    private Map<String, Book> receiveMap;

    @Autowired
    private Map<String, List<Book>> receiveMapList;

    @RabbitListener(queues = "querygraph2")
    public void work1(Message message) throws InterruptedException {
        logger.info("worker 2: "+message);

//        for (char ch: message.toCharArray()) {
//            if (ch == '.') Thread.sleep(500);
//        }

        byte[] body = message.getBody();
        System.out.println(new String(body));
        ObjectMapper mapper = new ObjectMapper();
        try {
            Bookl bookl = mapper.readValue(new String(body), Bookl.class);
            System.out.println(bookl.toString());
            // TODO: 2019-06-17 НЕ ДОБАВЛЕНА МУТАЦИЯ
            if (bookl.getMethod().equals("bookByIsn")){
                Book book = new Book();
                book.setIsn(bookl.getIsn());
                book.setTitle(bookl.getTitle());
                book.setPublished(bookl.getPublished());
                book.setPublisher(bookl.getPublisher());
                book.setAuthors(bookl.getAuthors());
                receiveMap.put(bookl.getReqId(), book);
            }else {
                receiveMapList.put(bookl.getReqId(), bookl.getBookList());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
