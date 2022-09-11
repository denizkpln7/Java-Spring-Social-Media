package com.project.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.demo.entities.Post;
import com.project.demo.entities.User;
import com.project.demo.reporsitory.PostRepository;
import com.project.demo.reporsitory.UserRepository;
import com.project.demo.request.PostCreateRequest;
import com.project.demo.request.PostUpdateRequest;
import com.project.demo.response.PostResponse;

@Service
public class PostService {
	
	private PostRepository postRepository;
	private UserRepository userRepository;

	public PostService(PostRepository postRepository, UserRepository userRepository) {
	
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	
	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			list=postRepository.findByUserId(userId);
		}
		else{
			list=postRepository.findAll();
		}
		return list.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());
		
     }

	public Post getOnePost(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnPost(PostCreateRequest post) {
		 Optional<User> user=userRepository.findById(post.getUserId());
		 if(user.isPresent()) {
			 Post toSave=new Post();
			 toSave.setId(post.getId());
			 toSave.setText(post.getText());
			 toSave.setTitle(post.getTitle());
			 toSave.setUser(user.get());
			 return postRepository.save(toSave);
		 }else {
			 return null;
		 }
		
	}


	public Post updateOnePostById(Long postId, PostUpdateRequest post) {
		 Optional<Post> uPost=postRepository.findById(postId);
		 if(uPost.isPresent()) {
			 uPost.get().setTitle(post.getTitle());
			 uPost.get().setText(post.getText());
			 return postRepository.save(uPost.get());
		 }
		return null;
	}


	public void deleteOnePostId(Long postId) {
		postRepository.deleteById(postId);
	}
	
	
	
	
	
	
}