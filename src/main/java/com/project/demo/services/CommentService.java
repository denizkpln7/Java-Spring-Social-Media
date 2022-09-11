package com.project.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.demo.entities.Comment;
import com.project.demo.entities.Post;
import com.project.demo.entities.User;
import com.project.demo.reporsitory.CommentRepository;
import com.project.demo.reporsitory.PostRepository;
import com.project.demo.reporsitory.UserRepository;
import com.project.demo.request.CommentCreateRequest;


@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;

	public CommentService(CommentRepository commentRepository, PostRepository postRepository,
			UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	

	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Comment> comments = null;
		if(userId.isPresent() && postId.isPresent()) {
			comments = commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			comments=commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			comments=commentRepository.findByPostId(postId.get());
		}else {
			comments=commentRepository.findAll();
		}
		
		return comments;
	}

	public Comment getOneComment(Long commentId) {
		
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest comment) {
		Optional<User> user=userRepository.findById(comment.getUserId());
		Optional<Post> post=postRepository.findById(comment.getPostId());
		
		Comment sComment =new Comment();
		if(user.isPresent() && post.isPresent()) {
			sComment.setId(comment.getId());
			sComment.setText(comment.getText());
			sComment.setUser(user.get());
			sComment.setPost(post.get());
			return commentRepository.save(sComment);
					
		}
		
		return null;
	}

}
