package com.tkb.tkbeat.front.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkb.tkbeat.front.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	Optional<List<User>> findByAccount(String account);
	
	

}
