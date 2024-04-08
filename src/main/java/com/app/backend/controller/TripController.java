package com.app.backend.controller;

import com.app.backend.DTOs.TripDTO;
import com.app.backend.entities.*;
import com.app.backend.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequiredArgsConstructor
@Slf4j
public class TripController {

    private final TripRepository tripRepository;


    @GetMapping(path = "/trips")
    public List<Trip> getAllTrips() {
        log.info(tripRepository.findAll().toString());
        return tripRepository.findAll();
    }
    @GetMapping("/trips/{id}")
    public Optional<Trip> tripById(@PathVariable(value = "id") Integer id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip;
    }
    @PostMapping("/trips/{id}/edit")
    public void tripEdit(@PathVariable(value = "id") Integer id,
                            @RequestBody TripDTO tripDTO) {
        log.info(tripDTO.getName());
        Trip trip = tripRepository.findById(id).orElseThrow();
        trip.setName(tripDTO.getName());
        trip.setBudget(tripDTO.getBudget());
        trip.setStartDate(tripDTO.getStartDate());
        trip.setEndDate(tripDTO.getEndDate());
        trip.setDayLimit(tripDTO.getDayLimit());
        trip.setDescription(tripDTO.getDescription());
        trip.setCurrencyName(tripDTO.getCurrencyName());
        trip.setUserLogin(tripDTO.getUserLogin());
        tripRepository.save(trip);
    }

}

