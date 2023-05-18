package com.example.repository.channel;

import com.example.entity.ChannelEntity;
import com.example.enums.GeneralStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.Transient;
import java.util.Optional;

public interface ChannelRepository  extends CrudRepository<ChannelEntity, String> {
    Optional<ChannelEntity> findByName(String name);
    Optional<ChannelEntity> findByProfile_id(Integer profile_id);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set name = :name, description = :description where profile_id = :profileId")
    Integer updateNameAndDescription(@Param("name") String name,
                                     @Param("description") String description,
                                     @Param("profileId") Integer profileId);

    @Query("from ChannelEntity where profile_id = :profileId")
    Optional<ChannelEntity> findByProfileId(@Param("profileId") Integer profileId);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set photo_id = :photo where profile_id = :profileId")
    void updatePhoto(@Param("photo")String photoId,
                     @Param("profileId")Integer profileId);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set banner_id = :banner where profile_id = :profileId")
    void updateBanner(@Param("banner")String banner,
                      @Param("profileId")Integer profileId);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set status = :status where profile_id = :profileId")
    ChannelEntity updateStatus(@Param("status") GeneralStatus status,
                               @Param("profileId")Integer profileId);
}
