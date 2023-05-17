package com.example.entity;

import com.example.entity.attach.AttachEntity;
import com.example.enums.GeneralStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "channel")
public class ChannelEntity {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo_id;
    @ManyToOne
    @JoinColumn(name = "photo")
    private AttachEntity photo;
    @Column(name = "status")
    private GeneralStatus status;
    @Column(name = "banner")
    private String banner_id;
    @ManyToOne
    @JoinColumn(name = "banner")
    private AttachEntity banner;
    @Column(name = "profile_id")
    private Integer profile_id;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}
