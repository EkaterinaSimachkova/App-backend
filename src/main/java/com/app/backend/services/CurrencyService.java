package com.app.backend.services;

import com.app.backend.DTOs.CurrencyDTO;
import com.app.backend.entities.Currency;
import com.app.backend.repositories.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public List<Currency> getAll() {
        List<Currency> currencies = currencyRepository.findAll();
        return currencies;
    }

    public Optional<Currency> getByName(String name) {
        Optional<Currency> currency = currencyRepository.findByName(name);
        return currency;
    }

    public void update(String name, CurrencyDTO currencyDTO) {
        Currency currency = currencyRepository.findByName(name).orElseThrow();
        currency.setFullName(currencyDTO.getFullName());
        currency.setSymbol(currencyDTO.getSymbol());
        currencyRepository.save(currency);
    }

    public void delete(String name) {
        currencyRepository.deleteByName(name);
    }

    /*public void create(String name, CurrencyDTO currencyDTO) {
        Currency currency = new Currency(
                name,
                currencyDTO.getFullName(),
                currencyDTO.getSymbol()
        );
        currencyRepository.save(currency);
    }*/
}
