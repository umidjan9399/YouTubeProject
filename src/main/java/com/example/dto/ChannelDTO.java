package com.example.dto;

import com.example.enums.GeneralStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelDTO {
    private Integer id;
    private String name;
    private String description;
    private String photo_id;
    private GeneralStatus status;
    private String banner_id;
    private Integer profile_id;
}
