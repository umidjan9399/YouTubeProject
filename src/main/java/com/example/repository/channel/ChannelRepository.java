package com.example.repository.channel;

import com.example.entity.ChannelEntity;
import com.example.enums.GeneralStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChannelRepository  extends CrudRepository<ChannelEntity, String> {
    Optional<ChannelEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set name = :name, description = :description where profileId = :profileId")
    void updateNameAndDescription(@Param("name") String name,
                                     @Param("description") String description,
                                     @Param("profileId") Integer profileId);

    @Query("from ChannelEntity where profileId = :profileId")
    Optional<ChannelEntity> findByProfileId(@Param("profileId") Integer profileId);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set photoId = :photo where profileId = :profileId")
    void updatePhoto(@Param("photo")String photoId,
                     @Param("profileId")Integer profileId);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set bannerId = :banner where profileId = :profileId")
    void updateBanner(@Param("banner")String banner,
                      @Param("profileId")Integer profileId);

    @Transactional
    @Modifying
    @Query("update  ChannelEntity set status = :status where profileId = :profileId")
    void updateStatus(@Param("status") GeneralStatus status,
                               @Param("profileId")Integer profileId);
}
