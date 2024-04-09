package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currency")
public class Currency {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "symbol")
    private String symbol;

    @OneToMany(mappedBy="currency")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy="currency")
    private Set<Trip> trips;
}
