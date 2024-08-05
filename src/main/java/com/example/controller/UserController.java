package com.example.controller;

import com.example.dto.UserResponseDto;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getUserById")
    public UserResponseDto getUserById(@RequestParam(name = "id") Long userId) {
        return userService.getUserById(userId);
    }
}
