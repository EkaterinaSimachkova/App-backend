package com.app.backend.services;

import com.app.backend.DTOs.CategoryDTO;
import com.app.backend.entities.Category;
import com.app.backend.repositories.CategoryRepository;
import com.app.backend.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CategoryService categoryService;


    @DisplayName("Должен вернуть список категорий, когда все категории найдены")
    @Test
    void getAll() {
        // given
        when(categoryRepository.findAll()).thenReturn(getCategories());
        // when
        List<Category> result = categoryService.getAll();
        // then
        assertThat(result).isNotNull();
    }

    @DisplayName("Должен вернуть пустой результат, когда категория не найдена по id")
    @Test
    void getByIdEmpty() {
        // given
        when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        // when
        Optional<Category> result = categoryService.getById(1);
        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("Должен вернуть категорию, когда категория найдена по id")
    @Test
    void getById() {
        // given
        Integer validId = 1;
        when(categoryRepository.findById(validId)).thenReturn(Optional.of(getCategory()));
        // when
        Optional<Category> category = categoryService.getById(validId);
        Category result = category.orElse(null);
        // then
        assertThat(result).isEqualTo(getCategory());
    }

    @DisplayName("Должен вернуть категорию, когда категория обновлена")
    @Test
    void update() {
        // given
        Integer validId = 1;
        when(categoryRepository.findById(validId)).thenReturn(Optional.of(getCategory()));
        when(categoryRepository.save(any(Category.class))).thenReturn(getCategory());
        // when
        Category result = categoryService.update(validId, getCategoryDTO());
        // then
        assertThat(result).isNotNull();
    }

    @DisplayName("Должен вернуть категорию, когда категория удалена")
    @Test
    void delete() {
        // given
        Integer validId = 1;
        when(categoryRepository.findById(validId)).thenReturn(Optional.of(getCategory()));
        // when

        // then
        assertAll(() -> categoryService.delete(validId));
    }

    @DisplayName("Должен вернуть категорию, когда категория сохранена")
    @Test
    void create() {
        // given
        when(categoryRepository.save(any(Category.class))).thenReturn(getCategory());
        // when
        Category result = categoryService.create(getCategoryDTO());
        // then
        assertThat(result).isNotNull();
    }

    private static Category getCategory() {
        Category category = new Category();
        category.setId(1);
        category.setName("test");
        return category;
    }

    private static List<Category> getCategories() {
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("test1");

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("test2");

        return List.of(category1, category2);
    }

    private static CategoryDTO getCategoryDTO() {
        CategoryDTO category = new CategoryDTO();
        category.setName("test");
        return category;
    }

}