package com.example.graphqlresolver;


import com.example.graphqlresolver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class GraphqlresolverApplication{


    public static void main(String[] args) {
        SpringApplication.run(GraphqlresolverApplication.class, args);
    }

}
