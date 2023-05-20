package com.example.controller;

import com.example.dto.VideoTagDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.service.VideoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video_tag")
public class VideoTagController {
    @Autowired
    private VideoTagService videoTagService;
    @PostMapping({"", "/create"})
    public ResponseEntity<Integer> create(@RequestBody VideoTagDTO dto) {
        return ResponseEntity.ok(videoTagService.create(dto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody VideoTagDTO dto){
        return ResponseEntity.ok(videoTagService.delete(dto));
    }
    @PostMapping("/get-video-tag/{id}")
    public ResponseEntity<?> getVideoTag (@PathVariable String id){
        return ResponseEntity.ok(videoTagService.getVideoTag(id));
    }
}
