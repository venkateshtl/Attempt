package com.learning.attemptapi.controller.dto;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String email;
    private String firstName;
    private String lastName;
}
