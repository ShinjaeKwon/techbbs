package com.sjk.techbbs.controller.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjk.techbbs.dto.UserDto;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PostMapping("/api/join")
	public ResponseEntity<String> join(@RequestBody UserDto userDto) {
		//TODO : Use Spring Security
		userService.join(userDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Join", userDto.getUsername());
		return new ResponseEntity<>("User Join", responseHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/api/update/user")
	public ResponseEntity<String> update(@RequestBody UserDto userDto) {
		User user = userService.update(userDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Update", user.getUsername());
		//TODO : Add User Session
		return new ResponseEntity<>("Update User", responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/api/withdrawal")
	public ResponseEntity<String> delete(@RequestBody UserDto userDto) {
		userService.withdrawal(userDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Withdrawal", userDto.getUsername());
		return new ResponseEntity<>("Delete User", responseHeaders, HttpStatus.OK);
	}
}
