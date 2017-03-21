package com.kithome.alichecker2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AppMain {

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class,args);

    }
}
