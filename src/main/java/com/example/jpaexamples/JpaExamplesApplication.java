package com.example.jpaexamples;

import com.example.jpaexamples.example13.springdatajpa.reposityory.impl.CustomizedRespoistoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomizedRespoistoryImpl.class)
public class JpaExamplesApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaExamplesApplication.class, args);
    }

}
