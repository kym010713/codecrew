package com.project.codecrew.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor		// 파라미터 없는 생성자 생
@AllArgsConstructor	 	// 모든 필드를 받는 생성자 생성 
@Builder				// 빌더 패턴 사용 
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long no;
	
	@Column(nullable =  false, unique = true)
	private String userid;
	
	@Column(nullable =  false)
	private String pw;
	
	@Column(nullable =  false)
	private String name;
	
	@Column(nullable =  false, unique = true)
	private String email;
	
}
