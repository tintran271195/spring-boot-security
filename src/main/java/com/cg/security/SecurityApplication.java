package com.cg.security;

import com.cg.security.model.Role;
import com.cg.security.model.User;
import com.cg.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_CUSTOMER"));
            userService.saveRole(new Role(null, "ROLE_CUSTOMER_CARE_STAFF"));
            userService.saveRole(new Role(null, "ROLE_STAFF"));
            userService.saveRole(new Role(null, "ROLE_STORE"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Tin Tran", "admin", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Thien Nguyen", "staff", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Huy Tran", "huytran123", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Khanh Den", "khanh123", "1234", new ArrayList<>()));

            userService.addRoleToUser("admin", "ROLE_ADMIN");
            userService.addRoleToUser("admin", "ROLE_STAFF");
            userService.addRoleToUser("admin", "ROLE_CUSTOMER_CARE_STAFF");
            userService.addRoleToUser("staff", "ROLE_STAFF");
            userService.addRoleToUser("huytran123", "ROLE_CUSTOMER_CARE_STAFF");
            userService.addRoleToUser("khanh123", "ROLE_CUSTOMER");

        };
    }
}
