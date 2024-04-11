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

    public Optional<Currency> getById(Integer id) {
        Optional<Currency> currency = currencyRepository.findById(id);
        return currency;
    }

    public void update(Integer id, CurrencyDTO currencyDTO) {
        Currency currency = currencyRepository.findById(id).orElseThrow();
        currency.setName(currency.getName());
        currency.setFullName(currencyDTO.getFullName());
        currency.setSymbol(currencyDTO.getSymbol());
        currencyRepository.save(currency);
    }

    public void delete(Integer id) {
        currencyRepository.deleteById(id);
    }

    public void create(CurrencyDTO currencyDTO) {
        Currency currency = Currency.builder()
                .name(currencyDTO.getName())
                .fullName(currencyDTO.getFullName())
                .symbol(currencyDTO.getSymbol())
                .build();
        currencyRepository.save(currency);
    }

}
