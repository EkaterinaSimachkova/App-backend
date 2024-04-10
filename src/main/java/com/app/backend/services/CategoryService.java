package com.app.backend.services;

import com.app.backend.DTOs.CategoryDTO;
import com.app.backend.entities.Category;
import com.app.backend.entities.User;
import com.app.backend.repositories.CategoryRepository;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    public List<Category> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Optional<Category> getById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    public void update(Integer id, CategoryDTO categoryDTO) {
        User user = getUser(categoryDTO.getUserId());

        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setUser(user);
        categoryRepository.save(category);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void create(CategoryDTO categoryDTO) {
        User user = getUser(categoryDTO.getUserId());

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .user(user)
                .build();
        categoryRepository.save(category);
    }

    private User getUser(Integer id) {
        if (id != null) {
            User user = userRepository.getReferenceById(id);
            return user;
        } else return null;
    }
}
