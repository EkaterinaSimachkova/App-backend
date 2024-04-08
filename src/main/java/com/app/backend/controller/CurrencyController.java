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
public class CurrencyController {

    private final CurrencyRepository currencyRepository;


    @GetMapping(path = "/currencies")
    public List<Currency> getAllCurrencies() {
        log.info(currencyRepository.findAll().toString());
        return currencyRepository.findAll();
    }
    @GetMapping("/currencies/{name}")
    public Optional<Currency> currencyByName(@PathVariable(value = "name") String name) {
        Optional<Currency> currency = currencyRepository.findByName(name);
        return currency;
    }

}

