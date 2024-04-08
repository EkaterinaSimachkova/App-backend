package com.app.backend.controller;

import com.app.backend.entities.*;
import com.app.backend.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;


    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        log.info(userRepository.findAll().toString());
        return userRepository.findAll();
    }
    @GetMapping("/users/{login}")
    public Optional<User> userByLogin(@PathVariable(value = "login") String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user;
    }

}

