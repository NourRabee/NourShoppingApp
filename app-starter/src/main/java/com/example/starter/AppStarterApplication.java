////////////////////////////////////////////////
//          author: Nour
//          filename: AppStarterApplication.java
//          2023
////////////////////////////////////////////////
package com.example.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"ps.exalt.shopping.app"})
@EntityScan({"ps.exalt.shopping.app.model"})
@EnableJpaRepositories("ps.exalt.shopping.app.repository")
@EnableMongoRepositories("ps.exalt.shopping.app.repository")
public class AppStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppStarterApplication.class, args);
    }


}
