package com.app.backend.services;

import com.app.backend.DTOs.TripCategoryDTO;
import com.app.backend.entities.TripCategory;
import com.app.backend.repositories.TripCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripCategoryService {
    private final TripCategoryRepository tripCategoryRepository;

    public List<TripCategory> getAll() {
        List<TripCategory> tripsCategories = tripCategoryRepository.findAll();
        return tripsCategories;
    }

    public Optional<TripCategory> getById(Integer id) {
        Optional<TripCategory> tripCategory = tripCategoryRepository.findById(id);
        return tripCategory;
    }

    public void update(Integer id, TripCategoryDTO tripCategoryDTO) {
        TripCategory tripCategory = tripCategoryRepository.findById(id).orElseThrow();
        tripCategory.setLimit(tripCategoryDTO.getLimit());
        //tripCategory.setTrip();
        //tripCategory.setCategory();
        tripCategoryRepository.save(tripCategory);
    }

    public void delete(Integer id) {
        tripCategoryRepository.deleteById(id);
    }

    /*public void create(Integer id, TripCategoryDTO tripCategoryDTO) {
        TripCategory tripCategory = new TripCategory(
                id,
                tripCategoryDTO.getLimit(),
                tripCategoryDTO.getTripId(),
                tripCategoryDTO.getCategoryName()
        );
        tripCategoryRepository.save(tripCategory);
    }*/
}
