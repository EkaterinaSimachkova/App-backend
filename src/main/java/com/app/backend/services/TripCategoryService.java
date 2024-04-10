package com.app.backend.services;

import com.app.backend.DTOs.TripCategoryDTO;
import com.app.backend.entities.Category;
import com.app.backend.entities.Trip;
import com.app.backend.entities.TripCategory;
import com.app.backend.repositories.CategoryRepository;
import com.app.backend.repositories.TripCategoryRepository;
import com.app.backend.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripCategoryService {
    private final TripCategoryRepository tripCategoryRepository;
    private final TripRepository tripRepository;
    private final CategoryRepository categoryRepository;

    public List<TripCategory> getAll() {
        List<TripCategory> tripsCategories = tripCategoryRepository.findAll();
        return tripsCategories;
    }

    public Optional<TripCategory> getById(Integer id) {
        Optional<TripCategory> tripCategory = tripCategoryRepository.findById(id);
        return tripCategory;
    }

    public void update(Integer id, TripCategoryDTO tripCategoryDTO) {
        Trip trip = getTrip(tripCategoryDTO.getTripId());
        Category category = getCategory(tripCategoryDTO.getCategoryId());

        TripCategory tripCategory = tripCategoryRepository.findById(id).orElseThrow();
        tripCategory.setLimit(tripCategoryDTO.getLimit());
        tripCategory.setTrip(trip);
        tripCategory.setCategory(category);
        tripCategoryRepository.save(tripCategory);
    }

    public void delete(Integer id) {
        tripCategoryRepository.deleteById(id);
    }

    public void create(TripCategoryDTO tripCategoryDTO) {
        Trip trip = getTrip(tripCategoryDTO.getTripId());
        Category category = getCategory(tripCategoryDTO.getCategoryId());

        TripCategory tripCategory = TripCategory.builder()
                .limit(tripCategoryDTO.getLimit())
                .trip(trip)
                .category(category)
                .build();
        tripCategoryRepository.save(tripCategory);
    }

    private Trip getTrip(Integer id) {
        Trip trip =  tripRepository.getReferenceById(id);
        return trip;
    }

    private Category getCategory(Integer id) {
        Category category =  categoryRepository.getReferenceById(id);
        return category;
    }
}
