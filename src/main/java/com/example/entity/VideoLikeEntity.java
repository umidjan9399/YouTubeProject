package com.example.entity;

import com.example.enums.VideoLikeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "video_like")
public class VideoLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "video_id")
    private String video_id;
    @ManyToOne
    @JoinColumn(name = "comment_id", insertable = false, updatable = false)
    private VideoEntity video;
    @Column(name = "profile_id")
    private Integer profile_id;
    @ManyToOne
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private ProfileEntity profile;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VideoLikeStatus commentLikeStatus;
}
