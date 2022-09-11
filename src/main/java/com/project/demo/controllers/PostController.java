package com.project.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.Post;
import com.project.demo.request.PostCreateRequest;
import com.project.demo.response.PostResponse;
import com.project.demo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
	@PostMapping
	public Post createOnPost(@RequestBody PostCreateRequest post) {
		return postService.createOnPost(post);
		
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePost(postId);
	}

}
