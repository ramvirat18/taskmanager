package com.example.taskmanager.service;

import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user)
    {
        return userRepository.save(user);
    }

    public String login(String email, String password) {

        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));

        if(passwordEncoder.matches(password,user.getPassword()))
        {
            return "Login Successfully";
        }
        else
        {
            throw new RuntimeException("Invalid Credentials");
        }

    }
}
