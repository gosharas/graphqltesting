package com.example.graphqlresolver;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class GraphqlresolverApplication{


    public static void main(String[] args) {
        SpringApplication.run(GraphqlresolverApplication.class, args);
    }

}
