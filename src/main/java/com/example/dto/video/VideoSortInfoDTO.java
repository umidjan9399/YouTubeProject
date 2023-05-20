package com.example.dto.video;

import com.example.dto.channel.ChannelInfoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoSortInfoDTO {
    private String id;
    private String title;
    private ChannelInfoDTO channel;
    private LocalDateTime publishedDate;
    private Integer viewCount;
    /*preview_attach(id,url),
    private duration)*/
}
