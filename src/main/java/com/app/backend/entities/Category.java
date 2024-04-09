package com.app.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    /*@Column(name = "user_login")
    private String userLogin;*/

    @ManyToOne
    @JoinColumn(name="user_login")
    private User user;

    @OneToMany(mappedBy="category")
    private Set<TripCategory> tripsCategories;
}
