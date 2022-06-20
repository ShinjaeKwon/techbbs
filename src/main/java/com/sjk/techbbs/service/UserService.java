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
		User user = findByUsername(userDto.getUsername());
		user.update(userDto.getPassword());
		return user;
	}

	@Transactional
	public void withdrawal(UserDto userDto) {
		User user = findByUsername(userDto.getUsername());
		userRepository.delete(user);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
			.orElseThrow(() -> new IllegalArgumentException("회원 찾기 실패"));
	}

	@Transactional(readOnly = true)
	public User findById(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new IllegalArgumentException("회원 찾기 실패"));
	}
}
