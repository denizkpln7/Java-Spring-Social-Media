package com.project.demo.reporsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Post;
import com.project.demo.request.PostCreateRequest;

public interface PostRepository extends JpaRepository<Post,Long>{

	List<Post> findByUserId(Optional<Long> userId);

	List<Post> findByUserId(Long userId);

	

}
