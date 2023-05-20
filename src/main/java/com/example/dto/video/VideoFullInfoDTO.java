package com.example.dto.video;

import com.example.dto.attach.AttachInfoDTO;
import com.example.dto.category.CategoryInfoDTO;
import com.example.dto.channel.ChannelInfoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoFullInfoDTO {
    private String id;
    private String title;
    private String description;
    private ChannelInfoDTO channel;
    private CategoryInfoDTO category;
    private AttachInfoDTO attach;
    private Integer viewCount;
    private Integer sharedCount;
    private LocalDateTime publishedDate;
    /*preview_attach(id,url)
    tagList(id,name),
    Like(like_count,dislikeCount,isUserLiked,IsUserDisliked),
    private duration)*/
}
