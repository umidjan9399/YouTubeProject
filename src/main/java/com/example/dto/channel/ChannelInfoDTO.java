package com.example.dto.channel;

import com.example.dto.attach.AttachInfoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChannelInfoDTO {
    private Integer id;
    private String name;
    private AttachInfoDTO photo;

    public ChannelInfoDTO(String channelId, String channelName, AttachInfoDTO attachInfoDTO) {


    }
}
