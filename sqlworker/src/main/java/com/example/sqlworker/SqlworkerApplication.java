package com.example.sqlworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SqlworkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlworkerApplication.class, args);
    }

}
