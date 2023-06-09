package com.example.service;

import com.example.dto.video.VideoTagDTO;
import com.example.entity.VideoTagEntity;
import com.example.mapper.VideoTagMapper;
import com.example.repository.VideoTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class VideoTagService {
    @Autowired
    private VideoTagRepository videoTagRepository;
    public Integer create(VideoTagDTO dto) {
        VideoTagEntity entity = new VideoTagEntity();
        entity.setId(dto.getId());
        entity.setVideoId(dto.getVideoId());
        entity.setTagId(dto.getTagId());
        videoTagRepository.save(entity); // save profile

        dto.setCreatedDate(entity.getCreatedDate());
        return entity.getId();
    }

    public int delete(VideoTagDTO dto) {
        return videoTagRepository.deleteByVideoIdAndTagId(dto.getVideoId(),dto.getTagId());
    }

    public List<VideoTagMapper> getVideoTag(String videoId) {
        return videoTagRepository.findAllByVideoIdToMapper(videoId);
    }
}
