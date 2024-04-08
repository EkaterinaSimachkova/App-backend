package com.app.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripCategory {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "limit")
    private Integer limit;

    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "categoryName")
    private String categoryName;

}
