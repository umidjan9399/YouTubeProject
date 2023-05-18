package com.example.dto.profile;

import com.example.dto.attach.AttachInfoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileInfoDTO {
    private Integer id;
    private String name;
    private String surname;
    private AttachInfoDTO photo;

    public ProfileInfoDTO(Integer profileId, String profileName, String profileSurname, AttachInfoDTO attachInfoDTO) {
    }
}
