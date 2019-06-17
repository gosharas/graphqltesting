package com.example.sqlworker.rabbit;

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
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


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
