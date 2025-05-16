package com.project.codecrew.user.service;

import org.springframework.stereotype.Service;

import com.project.codecrew.user.dto.UserDto;
import com.project.codecrew.user.entity.UserEntity;
import com.project.codecrew.user.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean existsByUserid(String userid) {
	    return userRepository.existsByUserid(userid);
	}

	public boolean existsByEmail(String email) {
	    return userRepository.existsByEmail(email);
	}
	
	public void registerUser(UserDto dto) {
		
		UserEntity user = UserEntity.builder()
				.userid(dto.getId())
				.pw(dto.getPw())
				.name(dto.getName())
				.email(dto.getEmail())
				.build(); // build 사용 시 꼭 붙여야함!
				
		userRepository.save(user);	
	}
	
}


