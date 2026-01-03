package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public String find(int id) {
        return "渡辺和徳";
    }
}
