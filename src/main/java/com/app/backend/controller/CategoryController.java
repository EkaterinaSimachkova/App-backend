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

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> categoryById(@PathVariable(value = "id") Integer id) {
        Optional<Category> category = categoryService.getById(id);
        return category
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/categories/{id}/update")
    public ResponseEntity<Void> categoryEdit(@PathVariable(value = "id") Integer id,
                                 @RequestBody CategoryDTO categoryDTO) {
        log.info(categoryDTO.getDescription());
        categoryService.update(id, categoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}/delete")
    public ResponseEntity<Void> categoryDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

