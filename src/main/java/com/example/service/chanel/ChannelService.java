package com.example.service.chanel;

import com.example.dto.ChannelDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.ChannelEntity;
import com.example.enums.GeneralStatus;
import com.example.exps.ItemDoubleFoundException;
import com.example.exps.ItemNotFoundException;
import com.example.repository.channel.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;
    public ChannelDTO createChannel(ChannelDTO dto) {
        Optional<ChannelEntity> optional = channelRepository.findByName(dto.getName());
        if (optional.isPresent()){
            throw new ItemDoubleFoundException("Mazgi bunaqa kanal mavjud");
        }
        ChannelEntity channel = new ChannelEntity();
        channel.setId(UUID.randomUUID().toString());
        channel.setName(dto.getName());
        channel.setDescription(dto.getDescription());
        channel.setPhoto_id(dto.getPhoto_id());
        channel.setBanner_id(dto.getBanner_id());
        channel.setStatus(GeneralStatus.ACTIVE);
        channel.setProfile_id(dto.getProfile_id());
        channelRepository.save(channel);
        dto.setId(channel.getId());
        dto.setStatus(channel.getStatus());
        return dto;
    }


    public Boolean update_profile(ChannelDTO dto) {
        Optional<ChannelEntity> optional = channelRepository.findByProfileId(dto.getProfile_id());
        if (optional.isEmpty()){
            throw new  ItemNotFoundException("Sizning kanalingiz mavjud emas");
        }

        ChannelEntity channel = new ChannelEntity();
        channel.setName(dto.getName());
        channel.setDescription(dto.getDescription());
        channelRepository.updateNameAndDescription(channel.getName(), channel.getDescription(), dto.getProfile_id());

        return true;
    }

    public Boolean update_photo(ChannelDTO dto) {
        Optional<ChannelEntity> optional = channelRepository.findByProfileId(dto.getProfile_id());
        if (optional.isEmpty()){
            throw new  ItemNotFoundException("Sizning kanalingiz mavjud emas");
        }

        ChannelEntity channel = new ChannelEntity();
        channel.setPhoto_id(dto.getPhoto_id());
        channelRepository.updatePhoto(channel.getPhoto_id(), dto.getProfile_id());
        return true;
    }

    public Boolean update_banner(ChannelDTO dto) {
        Optional<ChannelEntity> optional = channelRepository.findByProfileId(dto.getProfile_id());
        if (optional.isEmpty()){
            throw new  ItemNotFoundException("Sizning kanalingiz mavjud emas");
        }

        ChannelEntity channel = new ChannelEntity();
        channel.setBanner_id(dto.getPhoto_id());
        channelRepository.updateBanner(channel.getBanner_id(), dto.getProfile_id());
        return true;
    }

    public ChannelDTO getByChannelId(String id) {
        ChannelEntity channel = get(id);

        ChannelDTO channelDTO = new ChannelDTO();
        channelDTO.setId(channel.getId());
        channelDTO.setName(channel.getName());
        channelDTO.setDescription(channel.getDescription());
        channelDTO.setPhoto_id(channel.getPhoto_id());
        channelDTO.setBanner_id(channel.getBanner_id());
        channelDTO.setProfile_id(channel.getProfile_id());
        channelDTO.setStatus(channel.getStatus());
        return channelDTO;
    }

    public ChannelEntity get(String id) {
        Optional<ChannelEntity> optional = channelRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Article not found: " + id);
        }
        return optional.get();
    }

    public Boolean update_status(ChannelDTO dto) {
        channelRepository.updateStatus(dto.getStatus(), dto.getProfile_id());
        return true;
    }
}
