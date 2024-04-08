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
public class CategoryController {

    private final CategoryRepository categoryRepository;


    @GetMapping(path = "/categories")
    public List<Category> getAllCategories() {
        log.info(categoryRepository.findAll().toString());
        return categoryRepository.findAll();
    }
    @GetMapping("/categories/{name}")
    public Optional<Category> categoryByName(@PathVariable(value = "name") String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        return category;
    }

}

