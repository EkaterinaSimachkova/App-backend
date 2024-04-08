package com.app.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TripCategory {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "limit")
    private Integer limit;

    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "categoryName")
    private String categoryName;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public TripCategory(Integer id, Integer limit, Integer tripId, String categoryName) {
        this.id = id;
        this.limit = limit;
        this.tripId = tripId;
        this.categoryName = categoryName;
    }

}
