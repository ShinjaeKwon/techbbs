package com.sjk.techbbs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Test
	void 게시글_키워드_검색() {
		//given
		BoardWriteDto boardWriteDto = new BoardWriteDto("테스트 테스트", "게시글 테스트입니다.", "sjk6437", "운영체제");
		boardService.write(boardWriteDto);
		//when
		// List<Board> findBoards = boardService.searchByTitle(boardWriteDto.getTitle());
		//then
		// for (Board findBoard : findBoards) {
		// 	assertTrue(findBoard.getTitle().contains(boardWriteDto.getTitle()));
		// }
	}

	@Test
	void 게시글_키워드_검색_페이징() {
		//given
		BoardWriteDto boardWriteDto1 = new BoardWriteDto("테스트 테스트", "1", "sjk6437", "운영체제");
		BoardWriteDto boardWriteDto2 = new BoardWriteDto("테스트 테스트", "2", "sjk6437", "운영체제");
		BoardWriteDto boardWriteDto3 = new BoardWriteDto("테스트 테스트", "3", "sjk6437", "운영체제");
		BoardWriteDto boardWriteDto4 = new BoardWriteDto("테스트 테스트", "4", "sjk6437", "운영체제");
		BoardWriteDto boardWriteDto5 = new BoardWriteDto("테스트 테스트", "5", "sjk6437", "운영체제");
		BoardWriteDto boardWriteDto6 = new BoardWriteDto("테스트 테스트", "6", "sjk6437", "운영체제");
		boardService.write(boardWriteDto1);
		boardService.write(boardWriteDto2);
		boardService.write(boardWriteDto3);
		boardService.write(boardWriteDto4);
		boardService.write(boardWriteDto5);
		boardService.write(boardWriteDto6);
		//when
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
		Page<Board> findBoards = boardService.searchByTitle(boardWriteDto1.getTitle(), pageable);
		//then
		assertEquals(findBoards.getSize(), 5);
		assertEquals(findBoards.getTotalPages(), 2);
		List<Board> pagingResult = findBoards.getContent();
		for (Board board : pagingResult) {
			assertEquals(board.getTitle(), boardWriteDto1.getTitle());
		}
	}

}