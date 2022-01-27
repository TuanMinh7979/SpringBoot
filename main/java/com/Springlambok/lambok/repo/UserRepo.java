package com.Springlambok.lambok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Springlambok.lambok.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("SELECT entity FROM User entity WHERE email= :email")
	User findByEmail1(@Param("email") String email);

	User findByEmail(String email);
}
