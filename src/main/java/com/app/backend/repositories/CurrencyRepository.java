package com.app.backend.repositories;

import com.app.backend.entities.Category;
import com.app.backend.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
