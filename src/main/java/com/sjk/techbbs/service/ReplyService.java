package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;

import com.sjk.techbbs.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;
}
