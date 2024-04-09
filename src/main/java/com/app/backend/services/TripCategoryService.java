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
        return tripCategoryRepository.findAll();
    }

    public Optional<TripCategory> getById(Integer id) {
        return tripCategoryRepository.findById(id);
    }

    public void update(Integer id, TripCategoryDTO tripCategoryDTO) {
        TripCategory tripCategory = tripCategoryRepository.findById(id).orElseThrow();
        tripCategory.setLimit(tripCategoryDTO.getLimit());
        tripCategory.setTripId(tripCategoryDTO.getTripId());
        tripCategory.setCategoryName(tripCategoryDTO.getCategoryName());
        tripCategoryRepository.save(tripCategory);
    }

    public void delete(Integer id) {
        tripCategoryRepository.deleteById(id);
    }

    public void create(Integer id, TripCategoryDTO tripCategoryDTO) {
        TripCategory tripCategory = new TripCategory(
                id,
                tripCategoryDTO.getLimit(),
                tripCategoryDTO.getTripId(),
                tripCategoryDTO.getCategoryName()
        );
        tripCategoryRepository.save(tripCategory);
    }
}
