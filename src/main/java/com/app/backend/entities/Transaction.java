package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    /*@Column(name = "user_login")
    private String userLogin;*/

    @ManyToOne
    @JoinColumn(name="user_login")
    private User user;

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

    /*@Column(name = "currency_name")
    private String currencyName;*/

    @ManyToOne
    @JoinColumn(name="currency_name")
    private Currency currency;

}
