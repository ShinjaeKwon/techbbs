package com.sjk.techbbs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjk.techbbs.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
