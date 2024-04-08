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
public class Trip {

    @Id
    @Column(name = "id")
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

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "userLogin")
    private String userLogin;

}
