package com.sjk.techbbs.service;

import org.springframework.stereotype.Service;

import com.sjk.techbbs.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
}
