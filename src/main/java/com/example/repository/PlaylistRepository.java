package com.example.repository;

import com.example.entity.PlaylistEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlaylistRepository extends CrudRepository<PlaylistEntity, Integer> {
    @Transactional
    @Modifying
    @Query("update PlaylistEntity  set visible = false where id =:id")
    int updateVisible(@Param("id") Integer id);
}
