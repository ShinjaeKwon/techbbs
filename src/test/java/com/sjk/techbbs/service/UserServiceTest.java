package com.sjk.techbbs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.UserDto;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.UserRepository;

@SpringBootTest
@Transactional
class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	void 회원가입() {
		//given
		UserDto userDto = new UserDto("test", "1234", "test@naver.com");

		//when
		userService.join(userDto);

		//then
		User findUser = userRepository.findByUsername(userDto.getUsername())
			.get();

		assertEquals(userDto.getUsername(), findUser.getUsername());
		assertEquals(userDto.getPassword(), findUser.getPassword());
		assertEquals(userDto.getEmail(), findUser.getEmail());
	}

	@Test
	void 회원수정() {
		//given
		User user = userRepository.findByUsername("sjk6437").get();
		//when
		String newPassword = "1234";
		user.update(newPassword);
		//then
		assertEquals(user.getPassword(), newPassword);
	}

	@Test
	void 회원탈퇴() {
		//given
		UserDto userDto = new UserDto("test", "test123", "test@naver.com");
		userService.join(userDto);
		//when
		userService.withdrawal(userDto);
		//then
		assertTrue(userRepository.findByUsername(userDto.getUsername()).isEmpty());
	}

}