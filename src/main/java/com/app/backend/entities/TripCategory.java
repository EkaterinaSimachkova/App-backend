package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip_category")
public class TripCategory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "limit")
    private Integer limit;

    /*@Column(name = "trip_id")
    private Integer tripId;*/

    @ManyToOne
    @JoinColumn(name="trip_id")
    private Trip trip;

    /*@Column(name = "category_name")
    private String categoryName;*/

    @ManyToOne
    @JoinColumn(name="category_name")
    private Category category;

}
