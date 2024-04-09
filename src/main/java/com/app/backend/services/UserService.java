package com.app.backend.services;

import com.app.backend.DTOs.UserDTO;
import com.app.backend.entities.User;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getByLogin(String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user;
    }

    public void update(String login, UserDTO userDTO) {
        User user = userRepository.findByLogin(login).orElseThrow();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }

    public void delete(String login) {
        userRepository.deleteByLogin(login);
    }

    /*public void create(String login, UserDTO userDTO) {
        User user = new User(
                login,
                userDTO.getName(),
                userDTO.getPassword()
        );
        userRepository.save(user);
    }*/
}