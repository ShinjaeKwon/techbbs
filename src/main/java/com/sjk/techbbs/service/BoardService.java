package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.BoardUpdateDto;
import com.sjk.techbbs.dto.BoardWriteDto;
import com.sjk.techbbs.model.Board;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final UserService userService;

	@Transactional
	public void write(BoardWriteDto boardWriteDto) {
		User user = userService.findByUsername(boardWriteDto.getUsername());
		Board board = new Board(boardWriteDto, user);
		boardRepository.save(board);
	}

	@Transactional
	public void update(BoardUpdateDto boardUpdateDto) {
		Board board = boardRepository.findById(boardUpdateDto.getBoardId())
			.orElseThrow(() -> new IllegalArgumentException("게시글 불러오기 실패"));
		board.update(boardUpdateDto);
	}
}
