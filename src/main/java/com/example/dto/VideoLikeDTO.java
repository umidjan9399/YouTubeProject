package com.example.dto;

import com.example.enums.VideoLikeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoLikeDTO {
    private Integer id;
    private String video_id;
    private Integer profile_id;
    private VideoLikeStatus status;
}
