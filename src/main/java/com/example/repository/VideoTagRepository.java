package com.example.repository;

import com.example.entity.EmailHistoryEntity;
import com.example.entity.VideoTagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VideoTagRepository extends CrudRepository<VideoTagEntity, Integer>, Repository<VideoTagEntity, Integer> {
    int deleteByVideoIdAndTagId(String videoId,Integer tagId);
    List<VideoTagEntity> findAllByVideoId(String videoId);
}
