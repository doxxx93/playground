package me.doxxx.springeventdemo;

import me.doxxx.springeventdemo.event.UserRegisteredEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEventDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEventDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> ctx.publishEvent(new UserRegisteredEvent("Event example", "exampleUsername"));
    }
}
