package com.example.controller;

import com.example.dto.VideoDTO;
import com.example.service.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @PostMapping("/user/create")
    public ResponseEntity<VideoDTO> save(@RequestBody @Valid VideoDTO videoDTO) {
        return ResponseEntity.ok(videoService.create(videoDTO));
    }
    public ResponseEntity<Boolean> update(@PathVariable("id") String  id,
                                           @RequestBody VideoDTO videoDTO) {
        return ResponseEntity.ok(videoService.update(id, videoDTO));
    }
    @PutMapping("/user/updateStatus/{id}")
    public ResponseEntity<Boolean> updateStatus(@Valid @PathVariable("id") String id) {
        return ResponseEntity.ok(videoService.updateStatus(id));
    }
    @PutMapping("/public/viewCount/{id}")
    public ResponseEntity<Boolean> viewCount(@PathVariable("id") String  id) {
        return ResponseEntity.ok(videoService.viewCount(id));
    }
}
