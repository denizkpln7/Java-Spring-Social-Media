package com.project.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.demo.entities.Like;
import com.project.demo.entities.Post;
import com.project.demo.entities.User;
import com.project.demo.reporsitory.LikeRepository;
import com.project.demo.request.LikeCreateRequest;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
		
	}

	public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			return likeRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId.get());
		}else
			return likeRepository.findAll();
	}

	public Like getOneLikeById(Long LikeId) {
		return likeRepository.findById(LikeId).orElse(null);
	}

	

	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
	}


}
