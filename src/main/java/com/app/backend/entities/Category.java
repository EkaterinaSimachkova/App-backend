package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "userLogin")
    private String userLogin;

}
