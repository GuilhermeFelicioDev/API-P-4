package com.sistemapi4.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemapi4.projeto.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
