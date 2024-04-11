package com.app.backend.repositories;

import com.app.backend.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
