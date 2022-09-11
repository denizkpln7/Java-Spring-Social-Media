package com.project.demo.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String username);

}
