package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "trip_category")
public class TripCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "limit")
    private Integer limit;

    @ManyToOne
    @JoinColumn(name="trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
