package com.project.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.demo.entities.User;
import com.project.demo.reporsitory.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveOneUser(User user) {
		return userRepository.save(user);
	}

	public User getOneUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User updateOneUser(Long id, User user) {
		Optional<User> newUser=userRepository.findById(id);
		if(newUser.isPresent()) {
			newUser.get().setUserName(user.getUserName());
			newUser.get().setPassword(user.getPassword());
			 return userRepository.save(newUser.get());
		}
		else{
			return null;
		}
		
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

	public User getOneUserByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}
	
	

}
