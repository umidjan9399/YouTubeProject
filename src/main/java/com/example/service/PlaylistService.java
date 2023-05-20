package com.example.service;

import com.example.dto.playlist.PlaylistDTO;
import com.example.entity.ChannelEntity;
import com.example.entity.PlaylistEntity;
import com.example.enums.VideoStatus;
import com.example.exps.MethodNotAllowedException;
import com.example.repository.PlaylistRepository;
import com.example.repository.channel.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private ChannelRepository channelRepository;

    public Integer create(PlaylistDTO dto) {
        PlaylistEntity entity = new PlaylistEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setOrderNum(dto.getOrderNum());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setChannelId(dto.getChannelId());
        entity.setStatus(dto.getStatus());
        dto.setId(entity.getId());
        playlistRepository.save(entity);
        return entity.getId();
    }

    public Boolean update(Integer id, PlaylistDTO dto) {
        Optional<PlaylistEntity> playlist = playlistRepository.findById(id);
        Optional<ChannelEntity> channel = channelRepository.findById(playlist.get().getChannelId());
        if (channel == null) {
            throw new MethodNotAllowedException("channel not found");
        }
        PlaylistEntity entity = playlist.get();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setOrderNum(dto.getOrderNum());
        dto.setId(entity.getId());
        playlistRepository.save(entity);
        return true;
    }

    public Boolean updateStatus(Integer id) {
        Optional<PlaylistEntity> playlist = playlistRepository.findById(id);
        Optional<ChannelEntity> channel = channelRepository.findById(playlist.get().getChannelId());
        if (channel == null) {
            throw new MethodNotAllowedException("channel not found");
        }
        PlaylistEntity entity = playlist.get();
        if (playlist.get().getStatus().equals(VideoStatus.PUBLIC)){
            entity.setStatus(VideoStatus.PRIVATE);
            playlistRepository.save(entity);
            return  true;
        }else {
            entity.setStatus(VideoStatus.PUBLIC);
            playlistRepository.save(entity);
            return true;
        }
    }

    public Boolean delete(Integer id) {
        playlistRepository.updateVisible(id);
        return true;
    }
}
