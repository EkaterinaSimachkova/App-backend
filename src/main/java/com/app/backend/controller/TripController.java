package com.app.backend.controller;

import com.app.backend.DTOs.TripDTO;
import com.app.backend.entities.*;
import com.app.backend.services.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequiredArgsConstructor
@Slf4j
public class TripController {

    private final TripService tripService;


    @GetMapping(path = "/trips")
    public List<Trip> getAllTrips() {
        log.info(tripService.getAll().toString());
        var trips = tripService.getAll();
        return trips;
    }
    @GetMapping("/trips/{id}")
    public Optional<Trip> tripById(@PathVariable(value = "id") Integer id) {
        Optional<Trip> trip = tripService.getById(id);
        return trip;
    }
    @PostMapping("/trips/{id}/update")
    public void tripEdit(@PathVariable(value = "id") Integer id,
                            @RequestBody TripDTO tripDTO) {
        log.info(tripDTO.getName());
        tripService.update(id, tripDTO);
    }

    @DeleteMapping("/trips/{id}/delete")
    public void tripDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        tripService.delete(id);
    }


}

