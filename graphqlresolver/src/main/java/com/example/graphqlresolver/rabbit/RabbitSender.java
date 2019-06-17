package com.example.graphqlresolver.rabbit;



import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Bookl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RabbitSender {
    Logger logger = Logger.getLogger(String.valueOf(RabbitSender.class));
    private RabbitTemplate template;

    @Autowired
    public RabbitSender(RabbitTemplate template){
        this.template=template;
    }

    public void send(String bind, Book book) {
        /*ObjectMapper mapper = new ObjectMapper();
        String msg = null;
        try {
            msg = mapper.writeValueAsString(new InputTask());
        }catch (JsonProcessingException e){e.printStackTrace();}
        String message = outId;*/
        //template.setExchange("exchange-example-1");

//        if (bind.equals("error") || bind.equals("info") || bind.equals("warning")){
//            template.setExchange("direxchange-example-1");
//            template.convertAndSend(bind, message);
//        }else
//            return;
        template.setExchange("direxchangegraph");
        template.convertAndSend(bind, book);
        logger.info(" [x] Sent '" + book.toString() + "'");

    }
}
