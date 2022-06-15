package com.sjk.techbbs.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.sjk.techbbs.dto.UserJoinDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30, unique = true)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 50, unique = true)
	private String email;

	@Column(length = 20, columnDefinition = "varchar(20) default 'USER'")
	@Builder.Default
	@Enumerated(EnumType.STRING)
	private RoleType role = RoleType.USER;

	@CreationTimestamp
	private Timestamp createDate;

	public User(UserJoinDto userJoinDto) {
		this.username = userJoinDto.getUsername();
		this.password = userJoinDto.getPassword();
		this.email = userJoinDto.getEmail();
	}
}