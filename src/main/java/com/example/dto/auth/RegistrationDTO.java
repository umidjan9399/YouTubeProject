package com.example.dto.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    @NotEmpty(message = "name required")
    private String name;
    @NotEmpty(message = "surname required")
    private String surname;
    @NotEmpty(message = "email required")
    private String email;
    @NotEmpty(message = "photo required")
    private String photo;
    @NotEmpty(message = "password required")
    private String password;
}
