package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.UserJoinDto;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void join(UserJoinDto userJoinDto) {
		User user = new User(userJoinDto);
		userRepository.save(user);
	}
}
