package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;

import com.sjk.techbbs.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
}
