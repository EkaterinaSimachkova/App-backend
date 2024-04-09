package com.app.backend.DTOs;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class CategoryDTO {

    private String description;
    private String userLogin;

}
