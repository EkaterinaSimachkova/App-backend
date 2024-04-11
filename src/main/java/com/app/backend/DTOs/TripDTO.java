package com.app.backend.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class TripDTO {
    private String name;
    private Integer budget;
    private Date startDate;
    private Date endDate;
    private Integer dayLimit;
    private String description;
    private Integer currencyId;
    private Integer userId;

}
