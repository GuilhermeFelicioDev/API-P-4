package com.sistemapi4.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemapi4.projeto.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
