package com.sjk.techbbs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sjk.techbbs.dto.ReplyWriteDto;
import com.sjk.techbbs.model.Board;
import com.sjk.techbbs.model.Reply;
import com.sjk.techbbs.model.User;
import com.sjk.techbbs.repository.ReplyRepository;

@SpringBootTest
@Transactional
public class ReplyServiceTest {

	@Autowired
	private ReplyService replyService;

	@Autowired
	private UserService userService;

	@Autowired
	private BoardService boardService;

	@Autowired
	private ReplyRepository replyRepository;

	@Test
	void 댓글_작성() {
		//given
		Long boardId = 2L;
		String content = "첫번째 댓글입니다";
		Long userId = 1L;
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

	@Test
	void 댓글_삭제() {
		//given
		Long boardId = 2L;
		String content = "테스트 댓글입니다.";
		Long userId = 1L;
		replyService.write(new ReplyWriteDto(boardId, content, userId));
		Board board = boardService.findById(boardId);
		List<Reply> replies = board.getReplies();
		//when
		replyService.delete(replies.get(0).getId());
		//then
		Board findBoard = boardService.findById(boardId);
		List<Reply> findReplies = findBoard.getReplies();
		System.out.println(replies.get(0).getId());
		assertTrue(replyRepository.findById(findReplies.get(0).getId()).isEmpty());
	}

}
