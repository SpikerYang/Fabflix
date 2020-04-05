package com.spike.fabflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author spike
 * @Date: 2020-04-01 22:04
 */
@SpringBootApplication
public class fabflixMain80 extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(fabflixMain80.class, args);
        System.out.println("Boot!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(fabflixMain80.class);
    }
}
