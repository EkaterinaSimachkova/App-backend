package com.app.backend.controller;

import com.app.backend.DTOs.UserDTO;
import com.app.backend.entities.*;
import com.app.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();
        log.info(users.toString());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> userById(@PathVariable(value = "login") Integer id) {
        Optional<User> user = userService.getById(id);
        return user
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users/{id}/update")
    public ResponseEntity<Void> userEdit(@PathVariable(value = "id") Integer id,
                                 @RequestBody UserDTO userDTO) {
        log.info(userDTO.getName());
        userService.update(id, userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/delete")
    public ResponseEntity<Void> userDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public ResponseEntity<Void> userCreate(@RequestBody UserDTO userDTO) {
        log.info(userDTO.getLogin());
        userService.create(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

