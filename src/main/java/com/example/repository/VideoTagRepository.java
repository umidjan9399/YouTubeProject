package com.example.repository;

import com.example.entity.EmailHistoryEntity;
import com.example.entity.VideoTagEntity;
import com.example.mapper.VideoTagMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoTagRepository extends CrudRepository<VideoTagEntity, Integer>, Repository<VideoTagEntity, Integer> {
    int deleteByVideoIdAndTagId(String videoId,Integer tagId);
    List<VideoTagEntity> findAllByVideoId(String videoId);
    @Transactional
    @Modifying
    @Query(value = "SELECT v.id, v.video_id,v.tag_id,(SELECT t.name from tag as t where t.id = v.tag_id),v.created_date " +
            " FROM video_tag AS v  where  v.video_id =:v_id  order by created_date ", nativeQuery = true)
    List<VideoTagMapper> findAllByVideoIdToMapper(@Param("v_id") String v_id);

}
