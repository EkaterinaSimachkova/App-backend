package com.app.backend.controller;

import com.app.backend.entities.*;
import com.app.backend.repositories.*;
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

    private final TripCategoryRepository tripCategoryRepository;


    @GetMapping(path = "/trips_categories")
    public List<TripCategory> getAllTripsCategories() {
        log.info(tripCategoryRepository.findAll().toString());
        return tripCategoryRepository.findAll();
    }
    @GetMapping("/trips_categories/{id}")
    public Optional<TripCategory> tripCategoryById(@PathVariable(value = "id") Integer id) {
        Optional<TripCategory> tripCategory = tripCategoryRepository.findById(id);
        return tripCategory;
    }

}

