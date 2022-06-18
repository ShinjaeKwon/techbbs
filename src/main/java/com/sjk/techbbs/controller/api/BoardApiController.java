package com.sjk.techbbs.controller.api;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjk.techbbs.dto.BoardUpdateDto;
import com.sjk.techbbs.dto.BoardWriteDto;
import com.sjk.techbbs.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	@PostMapping("/board/write")
	public ResponseEntity<String> write(@RequestBody BoardWriteDto boardWriteDto) {
		boardService.write(boardWriteDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Write Board", boardWriteDto.getTitle());
		return new ResponseEntity<>("Write User : " + boardWriteDto.getUsername(), responseHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/board/update")
	public ResponseEntity<String> update(@RequestBody BoardUpdateDto boardUpdateDto) {
		boardService.update(boardUpdateDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Update Board", boardUpdateDto.getTitle());
		return new ResponseEntity<>("Update BoardId : " + boardUpdateDto.getBoardId(), responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/board/delete")
	public ResponseEntity<String> delete(@RequestBody Map<String, String> map) {
		boardService.delete(Long.parseLong(map.get("boardId")));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Delete Board", map.get("boardId"));
		return new ResponseEntity<>("Delete BoardId : " + map.get("boardId"), responseHeaders, HttpStatus.OK);
	}

}
