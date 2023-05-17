package com.example.entity;

import jakarta.persistence.criteria.CriteriaBuilder;

public class PlaylistEntity {
    private Integer id;
    private Integer channel_id;
    private String name;
    private String description;
    private String status;
    private Integer order_num;
}
