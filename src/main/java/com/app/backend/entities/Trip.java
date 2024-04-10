package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "day_limit")
    private Integer dayLimit;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="currency_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    /*@OneToMany(mappedBy="trip")
    private Set<TripCategory> tripCategories;

    @OneToMany(mappedBy="trip")
    private Set<Transaction> transactions;*/

}
