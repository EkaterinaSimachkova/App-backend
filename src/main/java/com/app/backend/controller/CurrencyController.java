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
    @GetMapping("/currencies/{name}")
    public ResponseEntity<Currency> currencyByName(@PathVariable(value = "name") String name) {
        Optional<Currency> currency = currencyService.getByName(name);
        return currency
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/currencies/{name}/update")
    public void currencyEdit(@PathVariable(value = "name") String name,
                             @RequestBody CurrencyDTO currencyDTO) {
        log.info(currencyDTO.getFullName());
        currencyService.update(name, currencyDTO);
    }

    @DeleteMapping("/currencies/{name}/delete")
    public void currencyDelete(@PathVariable(value = "name") String name) {
        log.info(name);
        currencyService.delete(name);
    }
}

