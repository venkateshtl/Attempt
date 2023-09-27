package com.learning.attemptapi.controller.dto;

import com.learning.attemptapi.model.Role;
import lombok.Data;

@Data
public class NewUserDto extends UserDto{
    private String password;

    public NewUserDto(String email, String firstName, String lastName, Role role) {
        super(email, firstName, lastName, role);
    }
}
