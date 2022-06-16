package com.sjk.techbbs.controller.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjk.techbbs.dto.BoardDto;
import com.sjk.techbbs.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	@PostMapping("/board/write")
	public ResponseEntity<String> write(@RequestBody BoardDto boardDto) {
		boardService.write(boardDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Write Board", boardDto.getTitle());
		return new ResponseEntity<>("Write User : " + boardDto.getUsername(), responseHeaders, HttpStatus.CREATED);
	}

}
