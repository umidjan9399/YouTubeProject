package com.example.mapper;

import java.time.LocalDateTime;
public interface VideoTagMapper {
    Integer id();
    String videoId();
    Integer TagId();
    String TagName();
    LocalDateTime createdDate();
}
