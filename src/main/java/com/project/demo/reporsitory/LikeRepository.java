package com.project.demo.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByUserIdAndPostId(Long long1, Long long2);

	List<Like> findByUserId(Long long1);

	List<Like> findByPostId(Long long1);

	List<Like> findByUserIdAndPostId(Long long1, Long long2);

}
