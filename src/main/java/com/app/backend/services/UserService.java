package com.app.backend.services;

import com.app.backend.DTOs.UserDTO;
import com.app.backend.entities.User;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public void update(Integer id, UserDTO userDTO) {
        var password = passwordEncoder.encode(userDTO.getPassword());

        User user = userRepository.findById(id).orElseThrow();
        user.setLogin(userDTO.getLogin());
        user.setName(userDTO.getName());
        user.setPassword(password);
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void create(UserDTO userDTO) {
        var password = passwordEncoder.encode(userDTO.getPassword());

        User user = User.builder()
                .login(userDTO.getLogin())
                .name(userDTO.getName())
                .password(password)
                .build();
        userRepository.save(user);
    }

}