package com.sjk.techbbs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.ReplyWriteDto;
import com.sjk.techbbs.model.Board;
import com.sjk.techbbs.model.Reply;
import com.sjk.techbbs.model.User;

@SpringBootTest
@Transactional
public class ReplyServiceTest {

	@Autowired
	private ReplyService replyService;

	@Autowired
	private UserService userService;

	@Autowired
	private BoardService boardService;

	@Test
	void 댓글_작성() {
		//given
		Long boardId = 12L;
		String content = "첫번째 댓글입니다";
		Long userId = 8L;
		ReplyWriteDto replyWriteDto = new ReplyWriteDto(boardId, content, userId);
		//when
		replyService.write(replyWriteDto);
		//then
		Board board = boardService.findById(boardId);
		Reply reply = board.getReplies().get(0);
		User user = userService.findById(userId);
		assertEquals(reply.getContent(), content);
		assertEquals(reply.getUser(), user);
	}

}
