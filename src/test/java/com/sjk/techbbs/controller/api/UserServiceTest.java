package com.sjk.techbbs.controller.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.UserJoinDto;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.UserRepository;
import com.sjk.techbbs.service.UserService;

@SpringBootTest
@Transactional
class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	void 회원가입() {
		//given
		UserJoinDto userJoinDto = new UserJoinDto("base6666", "1234", "base6666@naver.com");

		//when
		userService.join(userJoinDto);

		//then
		User findUser = userRepository.findByUsername(userJoinDto.getUsername())
			.get();

		assertEquals(userJoinDto.getUsername(), findUser.getUsername());
		assertEquals(userJoinDto.getPassword(), findUser.getPassword());
		assertEquals(userJoinDto.getEmail(), findUser.getEmail());

	}
}