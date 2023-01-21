package com.api.twetero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.twetero.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  User getReferenceByusername(String username);
}
