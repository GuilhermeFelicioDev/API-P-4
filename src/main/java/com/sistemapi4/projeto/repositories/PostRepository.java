package com.sistemapi4.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemapi4.projeto.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
