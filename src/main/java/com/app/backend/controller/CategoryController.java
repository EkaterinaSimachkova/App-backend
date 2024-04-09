package com.app.backend.controller;

import com.app.backend.DTOs.CategoryDTO;
import com.app.backend.entities.*;
import com.app.backend.services.CategoryService;
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

    private final CategoryService categoryService;


    @GetMapping(path = "/categories")
    public List<Category> getAllCategories() {
        log.info(categoryService.getAll().toString());
        return categoryService.getAll();
    }
    @GetMapping("/categories/{name}")
    public Optional<Category> categoryByName(@PathVariable(value = "name") String name) {
        Optional<Category> category = categoryService.getByName(name);
        return category;
    }

    @PostMapping("/categories/{name}/update")
    public void categoryEdit(@PathVariable(value = "name") String name,
                                 @RequestBody CategoryDTO categoryDTO) {
        log.info(categoryDTO.getDescription());
        categoryService.update(name, categoryDTO);
    }

    @DeleteMapping("/categories/{name}/delete")
    public void categoryDelete(@PathVariable(value = "name") String name) {
        log.info(name);
        categoryService.delete(name);
    }
}

