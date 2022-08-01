package com.test.application;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.test.application.controller.MainController;
import com.test.application.services.CovidService;

// Main Application
@ComponentScan(basePackageClasses = {MainController.class, CovidService.class})
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}