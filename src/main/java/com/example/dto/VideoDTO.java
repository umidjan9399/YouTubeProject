package com.example.dto;

import com.example.enums.VideoStatus;
import com.example.enums.VideoTypeStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoDTO {
    private String id;
    private String preview_attach_id;
    private String title;
    private Integer category_id;
    private String attach_id;
    private LocalDateTime created_date;
    private LocalDate published_date;
    private VideoStatus status;
    private VideoTypeStatus type;
    private Integer view_count;
    private Integer shared_count;
    private String description;
    private String channel_id;
    private Integer like_count;
    private Integer dislike_count;
}
