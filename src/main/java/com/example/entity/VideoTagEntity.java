package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "video_tag")
@Getter @Setter
public class VideoTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "video_id")
    private String videoId;
    @Column(name = "tag_id")
    private Integer tagId;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}
