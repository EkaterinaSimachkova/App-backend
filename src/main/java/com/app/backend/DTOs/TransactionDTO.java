package com.app.backend.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {
    private String name;
    private Integer cost;
    private Date date;
    private String description;
    private Integer userId;
    private Integer tripId;
    private Integer categoryId;
    private Integer currencyId;

}
