package com.app.backend.services;

import com.app.backend.DTOs.TransactionDTO;
import com.app.backend.entities.*;
import com.app.backend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final CategoryRepository categoryRepository;
    private final CurrencyRepository currencyRepository;

    public List<Transaction> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions;
    }

    public Optional<Transaction> getById(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction;
    }

    public void update(Integer id, TransactionDTO transactionDTO) {
        User user = getUser(transactionDTO.getUserId());
        Trip trip = getTrip(transactionDTO.getTripId());
        Category category = getCategory(transactionDTO.getCategoryId());
        Currency currency = getCurrency(transactionDTO.getCurrencyId());

        Transaction transaction = transactionRepository.findById(id).orElseThrow();
        transaction.setName(transactionDTO.getName());
        transaction.setCost(transactionDTO.getCost());
        transaction.setDate(transactionDTO.getDate());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setUser(user);
        transaction.setTrip(trip);
        transaction.setCategory(category);
        transaction.setCurrency(currency);
        transactionRepository.save(transaction);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }

    public void create(TransactionDTO transactionDTO) {
        User user = getUser(transactionDTO.getUserId());
        Trip trip = getTrip(transactionDTO.getTripId());
        Category category = getCategory(transactionDTO.getCategoryId());
        Currency currency = getCurrency(transactionDTO.getCurrencyId());

        Transaction transaction = Transaction.builder()
                .name(transactionDTO.getName())
                .cost(transactionDTO.getCost())
                .date(transactionDTO.getDate())
                .description(transactionDTO.getDescription())
                .user(user)
                .trip(trip)
                .category(category)
                .currency(currency)
                .build();
        transactionRepository.save(transaction);
    }

    private User getUser(Integer id) {
        if (id != null) {
            User user = userRepository.getReferenceById(id);
            return user;
        } else return null;
    }

    private Trip getTrip(Integer id) {
        if (id != null) {
            Trip trip =  tripRepository.getReferenceById(id);
            return trip;
        } else return null;
    }

    private Category getCategory(Integer id) {
        if (id != null) {
            Category category =  categoryRepository.getReferenceById(id);
            return category;
        } else return null;
    }

    private Currency getCurrency(Integer id) {
        if (id != null) {
            Currency currency = currencyRepository.getReferenceById(id);
            return currency;
        } else return null;
    }

}
