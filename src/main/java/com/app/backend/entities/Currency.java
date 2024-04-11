package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "symbol")
    private String symbol;

    /*@OneToMany(mappedBy="currency")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy="currency")
    private Set<Trip> trips;*/

}
