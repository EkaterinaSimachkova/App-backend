package com.app.backend.services;

import com.app.backend.DTOs.CategoryDTO;
import com.app.backend.entities.Category;
import com.app.backend.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        var categories = categoryRepository.findAll();
        return categories;
    }

    public Optional<Category> getByName(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        return category;
    }

    public void update(String name, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findByName(name).orElseThrow();
        category.setDescription(categoryDTO.getDescription());
        category.setUserLogin(categoryDTO.getUserLogin());
        categoryRepository.save(category);
    }

    public void delete(String name) {
        categoryRepository.deleteByName(name);
    }

    public void create(String name, CategoryDTO categoryDTO) {
        Category category = new Category(
                name,
                categoryDTO.getDescription(),
                categoryDTO.getUserLogin()
        );
        categoryRepository.save(category);
    }
}
