package com.dalma.fibrew.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.dalma.fibrew", "com.bybright.logging"})
public class DalmaFiBrewApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DalmaFiBrewApiApplication.class, args);
    }
}
