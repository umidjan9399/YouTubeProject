package com.example.dto;

import com.example.enums.VideoStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistDTO {
    private Integer id;
    private Integer channel_id;
    private String name;
    private String description;
    private VideoStatus status;
    private Integer order_num;
}
