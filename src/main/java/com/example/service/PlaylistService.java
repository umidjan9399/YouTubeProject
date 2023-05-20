package com.example.service;

import com.example.dto.playlist.PlaylistDTO;
import com.example.entity.ChannelEntity;
import com.example.entity.PlaylistEntity;
import com.example.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

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
        return true;
    }
}
