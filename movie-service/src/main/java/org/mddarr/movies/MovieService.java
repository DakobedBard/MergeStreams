package org.mddarr.movies;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = "org.mddarr.orders")
public class MovieService {

    public static void main(String[] args) {
        SpringApplication.run(MovieService.class, args);
    }
}
