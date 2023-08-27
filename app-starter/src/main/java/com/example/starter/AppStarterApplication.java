package com.example.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ps.exalt.shopping.app"})
@EntityScan({"ps.exalt.shopping.app.model"})
@EnableJpaRepositories({"ps.exalt.shopping.app.repository"})
public class AppStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppStarterApplication.class, args);
    }

}
