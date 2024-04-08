package com.app.backend.repositories;

import com.app.backend.entities.TripCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripCategoryRepository extends JpaRepository<TripCategory, Integer> {
}
