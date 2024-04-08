package com.app.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "userLogin")
    private String userLogin;

    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "currency_name")
    private String currencyName;

}
