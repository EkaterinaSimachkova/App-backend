package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip")
public class Trip {

    @Id
    @Column(name = "id")
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

    /*@Column(name = "currency_name")
    private String currencyName;*/

    @ManyToOne
    @JoinColumn(name="currency_name")
    private Currency currency;

    /*@Column(name = "user_login")
    private String userLogin;*/

    @ManyToOne
    @JoinColumn(name="user_login")
    private User user;

    @OneToMany(mappedBy="trip")
    private Set<TripCategory> tripsCategories;

    @OneToMany(mappedBy="trip")
    private Set<Transaction> transactions;

}
