package com.app.backend.DTOs;

import lombok.Data;


@Data
public class CategoryDTO {
    private String name;
    private String description;
    private Integer userId;

}
