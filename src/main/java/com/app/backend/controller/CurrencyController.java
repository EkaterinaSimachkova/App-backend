package com.app.backend.controller;

import com.app.backend.DTOs.CurrencyDTO;
import com.app.backend.entities.*;
import com.app.backend.services.CurrencyService;
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
public class CurrencyController {

    private final CurrencyService currencyService;


    @GetMapping(path = "/currencies")
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List<Currency> currencies = currencyService.getAll();
        log.info(currencies.toString());
        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/currencies/{id}")
    public ResponseEntity<Currency> currencyById(@PathVariable(value = "id") Integer id) {
        Optional<Currency> currency = currencyService.getById(id);
        return currency
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/currencies/{id}/update")
    public ResponseEntity<Void> currencyEdit(@PathVariable(value = "id") Integer id,
                             @RequestBody CurrencyDTO currencyDTO) {
        log.info(currencyDTO.getFullName());
        currencyService.update(id, currencyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/currencies/{id}/delete")
    public ResponseEntity<Void> currencyDelete(@PathVariable(value = "id") Integer id) {
        log.info(id.toString());
        currencyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/currencies/create")
    public ResponseEntity<Void> currencyCreate(@RequestBody CurrencyDTO currencyDTO) {
        log.info(currencyDTO.getFullName());
        currencyService.create(currencyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

