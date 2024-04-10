package com.app.backend.controller;

import com.app.backend.DTOs.TransactionDTO;
import com.app.backend.entities.*;
import com.app.backend.services.TransactionService;
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
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping(path = "/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAll();
        log.info(transactions.toString());
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> transactionById(@PathVariable(value = "id") Integer id) {
        Optional<Transaction> transaction = transactionService.getById(id);
        return transaction
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/transactions/{id}/update")
    public ResponseEntity<Void> transactionEdit(@PathVariable(value = "id") Integer id,
                         @RequestBody TransactionDTO transactionDTO) {
        log.info(transactionDTO.getName());
        transactionService.update(id, transactionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/transactions/{id}/delete")
    public ResponseEntity<Void> transactionDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        transactionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/transactions/create")
    public ResponseEntity<Void> transactionCreate(@RequestBody TransactionDTO transactionDTO) {
        log.info(transactionDTO.getName());
        transactionService.create(transactionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

