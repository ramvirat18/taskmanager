package com.example.taskmanager.controller;

import com.example.taskmanager.entity.User;
import com.example.taskmanager.service.UserService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser( @RequestBody User user)
    {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password)
    {
        return userService.login(email,password);
    }
}
