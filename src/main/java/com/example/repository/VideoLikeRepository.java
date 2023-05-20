package com.example.repository;

import com.example.entity.VideoLikeEntity;
import com.example.enums.VideoLikeStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VideoLikeRepository extends CrudRepository<VideoLikeEntity, Integer> {
    VideoLikeEntity getByProfile_id(Integer id);
    @Transactional
    @Modifying
    @Query("update VideoLikeEntity as a set a.commentLikeStatus = :status ")
    Integer updateStatus(@Param("status") VideoLikeStatus commentLikeStatus);
}
