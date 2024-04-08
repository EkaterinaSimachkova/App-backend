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
public class TransactionController {

    private final TransactionRepository transactionRepository;


    @GetMapping(path = "/transactions")
    public List<Transaction> getAllTransactions() {
        log.info(transactionRepository.findAll().toString());
        return transactionRepository.findAll();
    }
    @GetMapping("/transactions/{id}")
    public Optional<Transaction> transactionById(@PathVariable(value = "id") Integer id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction;
    }
}

