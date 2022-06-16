package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.BoardDto;
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
	public void write(BoardDto boardDto) {
		User user = userService.findByUsername(boardDto.getUsername());
		Board board = new Board(boardDto, user);
		boardRepository.save(board);
	}
}
