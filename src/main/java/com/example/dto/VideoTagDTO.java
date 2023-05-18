package com.example.dto;

import java.time.LocalDateTime;

public class VideoTagDTO {

    private Integer id;
    private String video_id;
    private Integer tag_id;
    private LocalDateTime created_date = LocalDateTime.now();
}
