package com.app.backend.controller;

import com.app.backend.DTOs.TripCategoryDTO;
import com.app.backend.entities.*;
import com.app.backend.services.TripCategoryService;
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
public class TripCategoryController {

    private final TripCategoryService tripCategoryService;


    @GetMapping(path = "/trips_categories")
    public ResponseEntity<List<TripCategory>> getAllTripsCategories() {
        List<TripCategory> tripsCategories = tripCategoryService.getAll();
        log.info(tripsCategories.toString());
        return ResponseEntity.ok(tripsCategories);
    }

    @GetMapping("/trips_categories/{id}")
    public ResponseEntity<TripCategory> tripCategoryById(@PathVariable(value = "id") Integer id) {
        Optional<TripCategory> tripCategory = tripCategoryService.getById(id);
        return tripCategory
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/trips_categories/{id}/update")
    public ResponseEntity<Void> tripCategoryEdit(@PathVariable(value = "id") Integer id,
                         @RequestBody TripCategoryDTO tripCategoryDTO) {
        log.info(tripCategoryDTO.getCategoryId().toString());
        tripCategoryService.update(id, tripCategoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/trips_categories/{id}/delete")
    public ResponseEntity<Void> tripCategoryDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        tripCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/trips_categories/create")
    public ResponseEntity<Void> tripCategoryCreate(@RequestBody TripCategoryDTO tripCategoryDTO) {
        log.info(tripCategoryDTO.getCategoryId().toString());
        tripCategoryService.create(tripCategoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

