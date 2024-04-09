package com.app.backend.controller;

import com.app.backend.DTOs.TransactionDTO;
import com.app.backend.entities.*;
import com.app.backend.services.TransactionService;
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

    private final TransactionService transactionService;


    @GetMapping(path = "/transactions")
    public List<Transaction> getAllTransactions() {
        log.info(transactionService.getAll().toString());
        return transactionService.getAll();
    }
    @GetMapping("/transactions/{id}")
    public Optional<Transaction> transactionById(@PathVariable(value = "id") Integer id) {
        Optional<Transaction> transaction = transactionService.getById(id);
        return transaction;
    }

    @PostMapping("/transactions/{id}/update")
    public void transactionEdit(@PathVariable(value = "id") Integer id,
                         @RequestBody TransactionDTO transactionDTO) {
        log.info(transactionDTO.getName());
        transactionService.update(id, transactionDTO);
    }

    @DeleteMapping("/transactions/{id}/delete")
    public void transactionDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        transactionService.delete(id);
    }
}

