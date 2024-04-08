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
public class Currency {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "symbol")
    private String symbol;

}
