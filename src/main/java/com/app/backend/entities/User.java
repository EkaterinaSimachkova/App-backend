package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

}
