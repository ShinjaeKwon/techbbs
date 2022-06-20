package com.sjk.techbbs.controller.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjk.techbbs.dto.ReplyWriteDto;
import com.sjk.techbbs.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyApiController {

	private final ReplyService replyService;

	@PostMapping("/reply/write")
	public ResponseEntity<String> write(@RequestBody ReplyWriteDto replyWriteDto) {
		replyService.write(replyWriteDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Write Reply", replyWriteDto.getContent());
		return new ResponseEntity<>("Board Id : " + replyWriteDto.getBoardId(), responseHeaders, HttpStatus.CREATED);
	}
}
