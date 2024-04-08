package com.app.backend.controller;

import com.app.backend.entities.*;
import com.app.backend.entities.Currency;
import com.app.backend.objects.TripRequest;
import com.app.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
public class AppController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TripCategoryRepository tripCategoryRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping(path = "/users")
    public List<User> getAllUsers(Model model) {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }
    @GetMapping("/users/{login}")
    public Optional<User> userByLogin(@PathVariable(value = "login") String login, Model model) {
        Optional<User> user = userRepository.findByLogin(login);
        return user;
    }

    @GetMapping(path = "/currencies")
    public List<Currency> getAllCurrencies(Model model) {
        System.out.println(currencyRepository.findAll());
        return currencyRepository.findAll();
    }
    @GetMapping("/currencies/{name}")
    public Optional<Currency> currencyByName(@PathVariable(value = "name") String name, Model model) {
        Optional<Currency> currency = currencyRepository.findByName(name);
        return currency;
    }
    @GetMapping(path = "/categories")
    public List<Category> getAllCategories(Model model) {
        System.out.println(categoryRepository.findAll());
        return categoryRepository.findAll();
    }
    @GetMapping("/categories/{name}")
    public Optional<Category> categoryByName(@PathVariable(value = "name") String name, Model model) {
        Optional<Category> category = categoryRepository.findByName(name);
        return category;
    }
    @GetMapping(path = "/trips")
    public List<Trip> getAllTrips(Model model) {
        System.out.println(tripRepository.findAll());
        return tripRepository.findAll();
    }
    @GetMapping("/trips/{id}")
    public Optional<Trip> tripById(@PathVariable(value = "id") Integer id, Model model) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip;
    }
    //@PostMapping("/trips/{id}/edit")
    @RequestMapping(method = {RequestMethod.POST}, path = "/trips/{id}/edit", consumes = {MediaType.APPLICATION_JSON_VALUE, "application/x-www-form-urlencoded", "application/x-www-form-urlencoded;charset=UTF-8"})
    public void tripEdit(@PathVariable(value = "id") Integer id,
                            @RequestBody TripRequest tripp,
                           /*@RequestParam String name,
                           @RequestParam Integer budget,
                           @RequestParam Date startDate,
                           @RequestParam Date endDate,
                           @RequestParam Integer dayLimit,
                           @RequestParam String description,
                           @RequestParam String currencyName,
                           @RequestParam String userLogin,*/
                           Model model) {
        System.out.println(tripp);
        /*Trip trip = tripRepository.findById(id).orElseThrow();
        trip.setName(name);
        trip.setBudget(budget);
        trip.setStartDate(startDate);
        trip.setEndDate(endDate);
        trip.setDayLimit(dayLimit);
        trip.setDescription(description);
        trip.setCurrencyName(currencyName);
        trip.setUserLogin(userLogin);
        tripRepository.save(trip);*/
    }
    @GetMapping(path = "/trips_categories")
    public List<TripCategory> getAllTripsCategories(Model model) {
        System.out.println(tripCategoryRepository.findAll());
        return tripCategoryRepository.findAll();
    }
    @GetMapping("/trips_categories/{id}")
    public Optional<TripCategory> tripCategoryById(@PathVariable(value = "id") Integer id, Model model) {
        Optional<TripCategory> tripCategory = tripCategoryRepository.findById(id);
        return tripCategory;
    }
    @GetMapping(path = "/transactions")
    public List<Transaction> getAllTransactions(Model model) {
        System.out.println(transactionRepository.findAll());
        return transactionRepository.findAll();
    }
    @GetMapping("/transactions/{id}")
    public Optional<Transaction> transactionById(@PathVariable(value = "id") Integer id, Model model) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction;
    }
}

