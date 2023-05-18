package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoTagDTO {

    private Integer id;
    private String videoId;
    private Integer tagId;
    private LocalDateTime createdDate;
}
