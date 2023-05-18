package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoTagDTO {

    private Integer id;
    private String video_id;
    private Integer tag_id;
    private LocalDateTime created_date = LocalDateTime.now();
}
