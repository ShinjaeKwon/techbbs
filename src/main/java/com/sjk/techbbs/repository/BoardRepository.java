package com.sjk.techbbs.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sjk.techbbs.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Optional<Board> findByTitle(String title);

	Page<Board> findAllByTitleContaining(String title, Pageable pageable);
}
