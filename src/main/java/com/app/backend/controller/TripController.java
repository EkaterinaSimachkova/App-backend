package com.app.backend.controller;

import com.app.backend.DTOs.TripDTO;
import com.app.backend.entities.*;
import com.app.backend.services.TripService;
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
public class TripController {

    private final TripService tripService;


    @GetMapping(path = "/trips")
    public ResponseEntity<List<Trip>> getAllTrips() {
        List<Trip> trips = tripService.getAll();
        log.info(trips.toString());
        return ResponseEntity.ok(trips);
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> tripById(@PathVariable(value = "id") Integer id) {
        Optional<Trip> trip = tripService.getById(id);
        return trip
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/trips/{id}/update")
    public ResponseEntity<Void> tripEdit(@PathVariable(value = "id") Integer id,
                            @RequestBody TripDTO tripDTO) {
        log.info(tripDTO.getName());
        tripService.update(id, tripDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/trips/{id}/delete")
    public ResponseEntity<Void> tripDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        tripService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/trips/create")
    public ResponseEntity<Void> tripCreate(@RequestBody TripDTO tripDTO) {
        log.info(tripDTO.getName());
        tripService.create(tripDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

