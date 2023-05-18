package com.example.dto.playlist;

import com.example.dto.channel.ChannelInfoDTO;
import com.example.dto.profile.ProfileInfoDTO;
import com.example.enums.VideoStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayListInfoDTO {
    private Integer id;
    private String name;
    private String description;
    private VideoStatus status;
    private Integer orderNum;
    private ChannelInfoDTO channel;
    private ProfileInfoDTO profile;
}
