package com.sjk.techbbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjk.techbbs.model.Reply;
import com.sjk.techbbs.model.User;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
