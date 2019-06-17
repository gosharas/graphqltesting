package com.example.sqlworker.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableRabbit
public class RabbitReceiver {
    Logger logger = Logger.getLogger(String.valueOf(RabbitReceiver.class));

    @RabbitListener(queues = "querygraph")
    public void work1(Message message) throws InterruptedException {
        logger.info("worker 1: "+message);

//        for (char ch: message.toCharArray()) {
//            if (ch == '.') Thread.sleep(500);
//        }

    }
}
