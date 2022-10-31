package com.example.webapi.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User akmal = new User("Akmal","", "akmal@gmail.com", 1);
            User alex = new User("Alex","", "alex@gmail.com", 2);

            repository.saveAll(List.of(akmal, alex));
        };
    }
}
