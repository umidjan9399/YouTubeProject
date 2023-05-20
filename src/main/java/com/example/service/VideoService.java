package com.example.service;

import com.example.dto.VideoDTO;
import com.example.entity.ChannelEntity;
import com.example.entity.PlaylistEntity;
import com.example.entity.ProfileEntity;
import com.example.entity.VideoEntity;
import com.example.enums.VideoStatus;
import com.example.exps.MethodNotAllowedException;
import com.example.repository.PlaylistRepository;
import com.example.repository.ProfileRepository;
import com.example.repository.VideoRepository;
import com.example.repository.channel.ChannelRepository;
import com.example.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private ProfileRepository profileRepository;
    public VideoDTO create(VideoDTO dto) {
        VideoEntity entity = new VideoEntity();
        entity.setCategoryId(dto.getCategoryId());
        entity.setAttachId(dto.getAttachId());
        entity.setDescription(dto.getDescription());
        entity.setChannelId(dto.getChannelId());
        entity.setTitle(dto.getTitle());
        entity.setPreviewAttachId(dto.getPreviewAttachId());
        entity.setType(dto.getType());
        dto.setId(entity.getId());
        videoRepository.save(entity);
        return dto;
    }

    public Boolean update(String id, VideoDTO dto) {
        Optional<VideoEntity> video = videoRepository.findById(id);
        Optional<ChannelEntity> channel = channelRepository.findById(video.get().getChannelId());
        Optional<ProfileEntity> profile = profileRepository.findById(channel.get().getProfileId());
        Integer owner = SpringSecurityUtil.getProfileId();
        if (owner != profile.get().getId()) {
            throw new MethodNotAllowedException("it's not owner ");
        }
        VideoEntity entity = video.get();
        entity.setCategoryId(dto.getCategoryId());
        entity.setDescription(dto.getDescription());
        entity.setChannelId(dto.getChannelId());
        entity.setTitle(dto.getTitle());
        entity.setPreviewAttachId(dto.getPreviewAttachId());
        entity.setType(dto.getType());
        dto.setId(entity.getId());
        videoRepository.save(entity);
        return true;
    }

    public Boolean updateStatus(String id) {
        Optional<VideoEntity> video = videoRepository.findById(id);
        Optional<ChannelEntity> channel = channelRepository.findById(video.get().getChannelId());
        Optional<ProfileEntity> profile = profileRepository.findById(channel.get().getProfileId());
        Integer owner = SpringSecurityUtil.getProfileId();
        VideoEntity entity = video.get();
        if (owner != profile.get().getId()) {
            throw new MethodNotAllowedException("it's not owner ");
        }
        if (video.get().getStatus().equals(VideoStatus.PUBLIC)){
            entity.setStatus(VideoStatus.PRIVATE);
            videoRepository.save(entity);
            return  true;
        }else {
            entity.setStatus(VideoStatus.PUBLIC);
            videoRepository.save(entity);
            return true;
        }
    }

    public Boolean viewCount(String id) {
        int count=videoRepository.viewCount(id);
        return true;
    }
}
