package com.example;

import com.example.dto.User;
import com.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@ComponentScan
public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        UserService userService = context.getBean(UserService.class);

        User newUser_1 = new User(1L, "John");
        User newUser_2 = new User(2L, "Alex");
        User updateUser = new User(1L, "Aron");
        userService.createUser(newUser_1);
        System.out.println(userService.getAllUsers());
        userService.createUser(newUser_2);
        System.out.println(userService.getAllUsers());
        System.out.println(userService.getUser(1L));
        userService.updateUser(updateUser);
        System.out.println(userService.getAllUsers());
        userService.deleteUser(2L);
        System.out.println(userService.getAllUsers());
    }
}
