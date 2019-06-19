package com.example.graphqlresolver.rabbit;

import com.example.graphqlresolver.models.Book;
import com.example.graphqlresolver.models.Lol;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan("com.example.graphqlresolver.rabbit")
public class RabbitConfig {
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        return connectionFactory;
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper;
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        template.setMessageConverter(jsonMessageConverter());
//        return template;
//    }


    @Bean
    public Map<String, Lol> reqMap(){ return Collections.synchronizedMap(new HashMap<>());}

    @Bean
    public Map<String, Book> receiveMap(){ return Collections.synchronizedMap(new HashMap<>());}

    @Bean
    public Map<String, List<Book>> receiveMapList(){ return Collections.synchronizedMap(new HashMap<>());}

    @Bean
    public Queue myQueue1() {
        return new Queue("querygraph");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("querygraph2");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direxchangegraph");
    }

    @Bean
    public Binding infoBinding(){
        return BindingBuilder.bind(myQueue1()).to(directExchange()).with("info");
    }

    @Bean
    public Binding infoBinding2(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("info2");
    }
}
