package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Character;
import com.example.demo.repository.CharacterRepository;

@Service
public class HomeService {
    private final CharacterRepository characterRepository;

    public HomeService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

}
