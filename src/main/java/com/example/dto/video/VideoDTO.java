package com.example.dto.video;

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
    private String id; //
    private String previewAttachId;
    private String title; //
    private Integer categoryId; //
    private String attachId; //
    private LocalDateTime createdDate; //
    private LocalDateTime publishedDate; //
    private VideoStatus status; //
    private VideoTypeStatus type; //
    private Integer viewCount; //
    private Integer sharedCount; //
    private String description; //
    private String channelId; //
    private Integer likeCount; //
    private Integer dislikeCount; //
}
