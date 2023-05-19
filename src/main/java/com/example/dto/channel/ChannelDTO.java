package com.example.dto.channel;

import com.example.enums.GeneralStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChannelDTO {
    private String id;
    private String name;
    private String description;
    private String photo_id;
    private GeneralStatus status;
    private String banner_id;
    private Integer profile_id;
}
