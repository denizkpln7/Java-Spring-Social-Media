package com.project.demo.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByUserIdAndPostId(Long long1, Long long2);

	List<Comment> findByUserId(Long long1);

	List<Comment> findByPostId(Long long1);

}
