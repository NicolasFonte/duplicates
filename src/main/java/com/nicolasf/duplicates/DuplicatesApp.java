package com.nicolasf.duplicates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DuplicatesApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DuplicatesApp.class, args);
    }
}
