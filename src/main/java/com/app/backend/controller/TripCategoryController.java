package com.app.backend.controller;

import com.app.backend.DTOs.TripCategoryDTO;
import com.app.backend.entities.*;
import com.app.backend.services.TripCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequiredArgsConstructor
@Slf4j
public class TripCategoryController {

    private final TripCategoryService tripCategoryService;


    @GetMapping(path = "/trips_categories")
    public List<TripCategory> getAllTripsCategories() {
        log.info(tripCategoryService.getAll().toString());
        return tripCategoryService.getAll();
    }
    @GetMapping("/trips_categories/{id}")
    public Optional<TripCategory> tripCategoryById(@PathVariable(value = "id") Integer id) {
        Optional<TripCategory> tripCategory = tripCategoryService.getById(id);
        return tripCategory;
    }

    @PostMapping("/trips_categories/{id}/update")
    public void tripCategoryEdit(@PathVariable(value = "id") Integer id,
                         @RequestBody TripCategoryDTO tripCategoryDTO) {
        log.info(tripCategoryDTO.getCategoryName());
        tripCategoryService.update(id, tripCategoryDTO);
    }

    @DeleteMapping("/trips_categories/{id}/delete")
    public void tripCategoryDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        tripCategoryService.delete(id);
    }
}

