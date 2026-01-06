package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class HomeService {
    private final UserRepository userRepository;

    public HomeService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User getUser() {
        Optional<User> user = userRepository.findById(1L);
        if (user.isPresent()) {
            return user.get();    
        }
        else {
            return null;
        }
    }
}
