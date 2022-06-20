package com.sjk.techbbs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		//TODO : Confirm User Validation from Board.user
		Board board = boardRepository.findById(boardUpdateDto.getBoardId())
			.orElseThrow(() -> new IllegalArgumentException("게시글 불러오기 실패"));
		board.update(boardUpdateDto);
	}

	@Transactional
	public void delete(Long boardId) {
		//TODO : Confirm User Validation from Board.user
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("게시글 불러오기 실패"));
		boardRepository.delete(board);
	}

	@Transactional
	public Page<Board> searchByTitle(String title, Pageable pageable) {
		return boardRepository.findAllByTitleContaining(title, pageable);
	}
}
