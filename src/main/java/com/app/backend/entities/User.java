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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    /*@OneToMany(mappedBy="user")
    private Set<Category> categories;

    @OneToMany(mappedBy="user")
    private Set<Trip> trips;

    @OneToMany(mappedBy="user")
    private Set<Transaction> transactions;*/

}
