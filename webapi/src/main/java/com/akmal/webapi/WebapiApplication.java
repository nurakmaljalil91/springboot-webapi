package com.akmal.webapi;

import com.akmal.webapi.domain.Role;
import com.akmal.webapi.domain.User;
import com.akmal.webapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@SpringBootApplication
public class WebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "USER_ROLE"));
            userService.saveRole(new Role(null, "MANAGER_ROLE"));
            userService.saveRole(new Role(null, "ADMIN_ROLE"));
            userService.saveRole(new Role(null, "SUPER_ADMIN_ROLE"));

            userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Maria Sharapova", "maria", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Mikel Essin", "mikel", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Amy Fukahaka", "amy", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Miayawaki Sakura", "sakura", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "USER_ROLE");
            userService.addRoleToUser("maria", "ADMIN_ROLE");
            userService.addRoleToUser("mikel", "MANAGER_ROLE");
            userService.addRoleToUser("amy", "SUPER_ADMIN_ROLE");
            userService.addRoleToUser("sakura", "SUPER_ADMIN_ROLE");
            userService.addRoleToUser("sakura", "ADMIN_ROLE");
            userService.addRoleToUser("sakura", "MANAGER_ROLE");
            userService.addRoleToUser("sakura", "USER_ROLE");
        };
    }

}
