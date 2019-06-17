package com.example.graphqlresolver.rabbit;

import com.example.graphqlresolver.models.Bookl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@EnableRabbit
public class RabbitReceiver {
    Logger logger = Logger.getLogger(String.valueOf(RabbitReceiver.class));

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
        } catch (IOException e) {
            e.printStackTrace();
        }



//        try {
//            ByteArrayInputStream in = new ByteArrayInputStream(body);
//            ObjectInputStream is = new ObjectInputStream(in);
//            Object o = is.readObject();
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }

    }
}
