package com.app.backend.controller;

import com.app.backend.DTOs.CategoryDTO;
import com.app.backend.entities.*;
import com.app.backend.services.CategoryService;
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
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAll();
        log.info(categories.toString());
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/{name}")
    public ResponseEntity<Category> categoryByName(@PathVariable(value = "name") String name) {
        Optional<Category> category = categoryService.getByName(name);
        return category
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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

