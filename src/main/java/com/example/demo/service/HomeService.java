package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class HomeService {
    private final UserRepository userRepository;

    public HomeService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public String getUserName() {
        return userRepository.find(1);
    }
}
