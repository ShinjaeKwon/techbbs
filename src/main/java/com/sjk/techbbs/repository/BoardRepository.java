package com.sjk.techbbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjk.techbbs.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Optional<Board> findByTitle(String title);

	List<Board> findAllByTitleContaining(String title);
}
