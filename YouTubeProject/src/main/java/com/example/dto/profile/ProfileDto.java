package com.example.dto.profile;

import com.example.enums.GeneralStatus;
import com.example.enums.ProfileRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {
    private Integer id;
    @NotNull(message = "name required")
    private String name;
    @NotNull(message = "surname required")
    private String surname;
    @NotNull(message = "email required")
    private String email;
    @NotNull(message = "photo required")
    private String photo;
    @NotNull(message = "password required")
    private String password;
    private ProfileRole role;
    private GeneralStatus status;
    private Boolean visible;
}
