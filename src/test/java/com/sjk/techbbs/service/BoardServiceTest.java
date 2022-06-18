package com.sjk.techbbs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.BoardUpdateDto;
import com.sjk.techbbs.dto.BoardWriteDto;
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
		BoardWriteDto boardWriteDto = new BoardWriteDto("게시글 테스트", "게시글 테스트입니다.", "sjk6437", "운영체제");
		//when
		boardService.write(boardWriteDto);
		//then
		Board findBoard = boardRepository.findByTitle(boardWriteDto.getTitle()).get();
		User user = userService.findByUsername("sjk6437");
		assertEquals(boardWriteDto.getTitle(), findBoard.getTitle());
		assertEquals(boardWriteDto.getContent(), findBoard.getContent());
		assertEquals(user, findBoard.getUser());
		assertEquals(boardWriteDto.getCategory(), findBoard.getCategory().getSubject());
	}

	@Test
	void 게시글_수정() {
		//given
		BoardUpdateDto boardUpdateDto = new BoardUpdateDto(4L, "게시글 수정", "게시글 수정", "알고리즘");
		//when
		boardService.update(boardUpdateDto);
		//then
		Board findBoard = boardRepository.findById(4L).get();
		User user = userService.findByUsername("sjk6437");
		assertEquals(boardUpdateDto.getTitle(), findBoard.getTitle());
		assertEquals(boardUpdateDto.getContent(), findBoard.getContent());
		assertEquals(user, findBoard.getUser());
		assertEquals(boardUpdateDto.getCategory(), findBoard.getCategory().getSubject());
	}

	@Test
	void 게시글_삭제() {
		//given
		Long boardId = 4L;
		//when
		boardService.delete(boardId);
		//then
		assertTrue(boardRepository.findById(boardId).isEmpty());
	}
	
}