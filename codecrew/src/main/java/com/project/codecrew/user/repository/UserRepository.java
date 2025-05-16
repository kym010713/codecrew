package com.project.codecrew.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.codecrew.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	boolean existsByUserid(String userid);   
    boolean existsByEmail(String email); 
}
