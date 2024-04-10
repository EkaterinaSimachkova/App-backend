package com.app.backend.services;

import com.app.backend.DTOs.TripDTO;
import com.app.backend.entities.Currency;
import com.app.backend.entities.Trip;
import com.app.backend.entities.User;
import com.app.backend.repositories.CurrencyRepository;
import com.app.backend.repositories.TripRepository;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public List<Trip> getAll() {
        List<Trip> trips = tripRepository.findAll();
        return trips;
    }

    public Optional<Trip> getById(Integer id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip;
    }

    public void update(Integer id, TripDTO tripDTO) {
        Currency currency = getCurrency(tripDTO.getCurrencyId());
        User user = getUser(tripDTO.getUserId());

        Trip trip = tripRepository.findById(id).orElseThrow();
        trip.setName(tripDTO.getName());
        trip.setBudget(tripDTO.getBudget());
        trip.setStartDate(tripDTO.getStartDate());
        trip.setEndDate(tripDTO.getEndDate());
        trip.setDayLimit(tripDTO.getDayLimit());
        trip.setDescription(tripDTO.getDescription());
        trip.setCurrency(currency);
        trip.setUser(user);
        tripRepository.save(trip);
    }

    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }

    public void create(TripDTO tripDTO) {
        Currency currency = getCurrency(tripDTO.getCurrencyId());
        User user = getUser(tripDTO.getUserId());

        Trip trip = Trip.builder()
                .name(tripDTO.getName())
                .budget(tripDTO.getBudget())
                .startDate(tripDTO.getStartDate())
                .endDate(tripDTO.getEndDate())
                .dayLimit(tripDTO.getDayLimit())
                .description(tripDTO.getDescription())
                .currency(currency)
                .user(user)
                .build();
        tripRepository.save(trip);
    }

    private User getUser(Integer id) {
        if (id != null) {
            User user = userRepository.getReferenceById(id);
            return user;
        } else return null;
    }

    private Currency getCurrency(Integer id) {
        if (id != null) {
            Currency currency = currencyRepository.getReferenceById(id);
            return currency;
        } else return null;
    }
}
