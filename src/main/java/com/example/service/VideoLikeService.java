package com.example.service;


import com.example.dto.VideoLikeDTO;
import com.example.entity.VideoLikeEntity;
import com.example.enums.VideoLikeStatus;
import com.example.repository.VideoLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoLikeService {
    @Autowired
    private VideoLikeRepository videoLikeRepository;
    public VideoLikeDTO commentLike(VideoLikeDTO commentDto) {
        VideoLikeEntity commentLike = videoLikeRepository.getByProfile_id(commentDto.getProfile_id());
        if (commentLike != null){
            if (commentLike.getCommentLikeStatus() == VideoLikeStatus.DISLIKE) {
                videoLikeRepository.updateStatus(VideoLikeStatus.LIKE);
                commentLike.setCommentLikeStatus(VideoLikeStatus.LIKE);
                commentDto.setId(commentLike.getId());
                commentDto.setStatus(commentLike.getCommentLikeStatus());
                return commentDto;
            }
            if (commentLike.getCommentLikeStatus() == VideoLikeStatus.LIKE){
                videoLikeRepository.delete(commentLike);
                return null;
            }
        }
        VideoLikeEntity commentLikeEntity = new VideoLikeEntity();
        commentLikeEntity.setVideo_id(commentDto.getVideo_id());
        commentLikeEntity.setProfile_id(commentDto.getProfile_id());
        commentLikeEntity.setCommentLikeStatus(VideoLikeStatus.LIKE);
        videoLikeRepository.save(commentLikeEntity);
        commentDto.setId(commentLikeEntity.getId());
        commentDto.setStatus(commentLikeEntity.getCommentLikeStatus());
        return commentDto;
    }

    public VideoLikeDTO commentDislike(VideoLikeDTO commentDto) {
        VideoLikeEntity commentLike = videoLikeRepository.getByProfile_id(commentDto.getProfile_id());
        if (commentLike != null){
            if (commentLike.getCommentLikeStatus() == VideoLikeStatus.LIKE) {
                videoLikeRepository.updateStatus(VideoLikeStatus.DISLIKE);
                commentLike.setCommentLikeStatus(VideoLikeStatus.DISLIKE);
                commentDto.setId(commentLike.getId());
                commentDto.setStatus(commentLike.getCommentLikeStatus());
                return commentDto;
            }
            if (commentLike.getCommentLikeStatus() == VideoLikeStatus.DISLIKE){
                videoLikeRepository.delete(commentLike);
                return null;
            }
        }
        VideoLikeEntity commentLikeEntity = new VideoLikeEntity();
        commentLikeEntity.setVideo_id(commentDto.getVideo_id());
        commentLikeEntity.setProfile_id(commentDto.getProfile_id());
        commentLikeEntity.setCommentLikeStatus(VideoLikeStatus.DISLIKE);
        videoLikeRepository.save(commentLikeEntity);
        commentDto.setId(commentLikeEntity.getId());
        commentDto.setStatus(commentLikeEntity.getCommentLikeStatus());
        return commentDto;
    }

    public Boolean deleteLike(VideoLikeDTO commentLikeDto) {
        VideoLikeEntity commentLike = videoLikeRepository.getByProfile_id(commentLikeDto.getProfile_id());
        if (commentLike != null){
            videoLikeRepository.delete(commentLike);
        }
        return true;
    }
}
