package com.app.backend.objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.Date;


public class TripRequest {

    private String name;

    private Integer budget;

    private Date startDate;

    private Date endDate;

    private Integer dayLimit;

    private String description;

    private String currencyName;

    private String userLogin;

    public String getName() {
        return name;
    }

    public Integer getBudget() {
        return budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getDayLimit() {
        return dayLimit;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getUserLogin() {
        return userLogin;
    }
}
