package com.app.backend.DTOs;

import lombok.Data;


@Data
public class UserDTO {
    private String login;
    private String name;
    private String password;

}
