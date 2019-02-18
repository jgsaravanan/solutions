package com.example.solutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EntityScan(basePackages = "com.example.solutions.entity")
@EnableJpaRepositories(basePackages = "com.example.solutions.repositories")
@EnableSwagger2
public class SolutionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolutionsApplication.class, args);
    }

}

