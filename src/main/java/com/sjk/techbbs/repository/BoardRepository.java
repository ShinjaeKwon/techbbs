package com.sjk.techbbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjk.techbbs.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
