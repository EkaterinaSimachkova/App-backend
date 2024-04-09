package com.app.backend.controller;

import com.app.backend.DTOs.TripCategoryDTO;
import com.app.backend.DTOs.UserDTO;
import com.app.backend.entities.*;
import com.app.backend.services.UserService;
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

    private final UserService userService;


    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        log.info(userService.getAll().toString());
        return userService.getAll();
    }
    @GetMapping("/users/{login}")
    public Optional<User> userByLogin(@PathVariable(value = "login") String login) {
        Optional<User> user = userService.getByLogin(login);
        return user;
    }

    @PostMapping("/users/{login}/update")
    public void userEdit(@PathVariable(value = "login") String login,
                                 @RequestBody UserDTO userDTO) {
        log.info(userDTO.getName());
        userService.update(login, userDTO);
    }

    @DeleteMapping("/users/{login}/delete")
    public void userDelete(@PathVariable(value = "login") String login) {
        log.info(login);
        userService.delete(login);
    }
}

