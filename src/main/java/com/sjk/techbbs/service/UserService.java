package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.UserDto;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void join(UserDto userDto) {
		User user = new User(userDto);
		userRepository.save(user);
	}

	@Transactional
	public User update(UserDto userDto) {
		User user = userRepository.findByUsername(userDto.getUsername())
			.orElseThrow(() -> new IllegalArgumentException("회원 찾기 실패"));
		user.update(userDto.getPassword());
		return user;
	}
}
