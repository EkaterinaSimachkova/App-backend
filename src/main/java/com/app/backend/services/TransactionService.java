package com.app.backend.services;

import com.app.backend.DTOs.TransactionDTO;
import com.app.backend.entities.Transaction;
import com.app.backend.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions;
    }

    public Optional<Transaction> getById(Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction;
    }

    public void update(Integer id, TransactionDTO transactionDTO) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow();
        transaction.setName(transactionDTO.getName());
        transaction.setCost(transactionDTO.getCost());
        transaction.setDate(transactionDTO.getDate());
        transaction.setDescription(transactionDTO.getDescription());
        //transaction.setUser();
        //transaction.setTrip();
        //transaction.setCategory();
        //transaction.setCurrency();
        transactionRepository.save(transaction);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }

    /*public void create(Integer id, TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction(
                id,
                transactionDTO.getName(),
                transactionDTO.getCost(),
                transactionDTO.getDate(),
                transactionDTO.getDescription(),
                transactionDTO.getUserLogin(),
                transactionDTO.getTripId(),
                transactionDTO.getCategoryName(),
                transactionDTO.getCurrencyName()
        );
        transactionRepository.save(transaction);
    }*/
}
