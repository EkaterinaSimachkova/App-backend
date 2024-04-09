package com.app.backend.DTOs;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class UserDTO {

    private String name;
    private String password;

}
