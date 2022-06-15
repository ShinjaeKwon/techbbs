package com.sjk.techbbs.controller.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjk.techbbs.dto.UserJoinDto;
import com.sjk.techbbs.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PostMapping("/api/join")
	public ResponseEntity<String> join(@RequestBody UserJoinDto userJoinDto) {
		userService.join(userJoinDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Join", userJoinDto.getUsername());
		return new ResponseEntity<>("User Join", responseHeaders, HttpStatus.CREATED);
	}
}
