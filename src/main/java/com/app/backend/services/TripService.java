package com.app.backend.services;

import com.app.backend.DTOs.TripDTO;
import com.app.backend.entities.Trip;
import com.app.backend.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public List<Trip> getAll() {
        List<Trip> trips = tripRepository.findAll();
        return trips;
    }

    public Optional<Trip> getById(Integer id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip;
    }

    public void update(Integer id, TripDTO tripDTO) {
        Trip trip = tripRepository.findById(id).orElseThrow();
        trip.setName(tripDTO.getName());
        trip.setBudget(tripDTO.getBudget());
        trip.setStartDate(tripDTO.getStartDate());
        trip.setEndDate(tripDTO.getEndDate());
        trip.setDayLimit(tripDTO.getDayLimit());
        trip.setDescription(tripDTO.getDescription());
        //trip.setCurrency();
        //trip.setUser();
        tripRepository.save(trip);
    }

    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }

    /*public void create(Integer id, TripDTO tripDTO) {
        Trip trip = new Trip(
                id,
                tripDTO.getName(),
                tripDTO.getBudget(),
                tripDTO.getStartDate(),
                tripDTO.getEndDate(),
                tripDTO.getDayLimit(),
                tripDTO.getDescription(),
                tripDTO.getCurrencyName(),
                tripDTO.getUserLogin()
        );
        tripRepository.save(trip);
    }*/
}
