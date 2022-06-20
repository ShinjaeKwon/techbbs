package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.ReplyWriteDto;
import com.sjk.techbbs.model.Board;
import com.sjk.techbbs.model.Reply;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;
	private final BoardService boardService;
	private final UserService userService;

	@Transactional
	public void write(ReplyWriteDto replyWriteDto) {
		Board board = boardService.findById(replyWriteDto.getBoardId());
		User user = userService.findById(replyWriteDto.getUserId());
		Reply reply = new Reply(replyWriteDto.getContent(), user, board);
		board.addReply(reply);
		replyRepository.save(reply);
	}
}
