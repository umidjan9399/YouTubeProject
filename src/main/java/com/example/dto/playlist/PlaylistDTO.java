package com.example.dto.playlist;

import com.example.enums.VideoStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistDTO {
    private Integer id;
    private String channelId;
    private String name;
    private String description;
    private VideoStatus status;
    private Integer orderNum;
    private LocalDateTime createdDate;
}
