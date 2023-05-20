package com.example.controller;

import com.example.dto.VideoLikeDTO;
import com.example.service.VideoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video-like")
public class VideoLikeController {
    @Autowired
    private VideoLikeService videoLikeService;

    @PostMapping("/like")
    private ResponseEntity<VideoLikeDTO> likeCommentLike(@RequestBody VideoLikeDTO commentDto){
        return ResponseEntity.ok(videoLikeService.commentLike(commentDto));
    }

    @PostMapping("/dislike")
    private ResponseEntity<VideoLikeDTO> dislikeCommentLike(@RequestBody VideoLikeDTO commentDto){
        return ResponseEntity.ok(videoLikeService.commentDislike(commentDto));
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Boolean> deleteLike(@RequestBody VideoLikeDTO commentLikeDto){
        return ResponseEntity.ok(videoLikeService.deleteLike(commentLikeDto));
    }





}
