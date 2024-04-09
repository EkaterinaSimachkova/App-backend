package com.app.backend.DTOs;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class CurrencyDTO {

    private String fullName;
    private String symbol;

}
