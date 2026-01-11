package com.blog.blogging.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.blogging.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	
	@Query("SELECT u FROM User u WHERE u.email = :identifier OR u.name = :identifier")
	Optional<User> findByEmailOrName(@Param("identifier") String identifier);

	
//	 Optional<User> findByEmail(String email);
//
//	Optional<User> findByName(String identifier);
	

}
