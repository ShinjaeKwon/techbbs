package com.sjk.techbbs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.BoardDto;
import com.sjk.techbbs.model.Board;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.BoardRepository;

@SpringBootTest
@Transactional
class BoardServiceTest {

	@Autowired
	private BoardService boardService;

	@Autowired
	private UserService userService;

	@Autowired
	private BoardRepository boardRepository;

	@Test
	void 게시글_작성() {
		//given
		BoardDto boardDto = new BoardDto("게시글 테스트", "게시글 테스트입니다.", "sjk6437", "운영체제");
		//when
		boardService.write(boardDto);
		//then
		Board findBoard = boardRepository.findByTitle(boardDto.getTitle()).get();
		User user = userService.findByUsername("sjk6437");
		assertEquals(boardDto.getTitle(), findBoard.getTitle());
		assertEquals(boardDto.getContent(), findBoard.getContent());
		assertEquals(user, findBoard.getUser());
		assertEquals(boardDto.getCategory(), findBoard.getCategory().getSubject());
	}
}