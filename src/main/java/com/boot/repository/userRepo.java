package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.Login;

@Repository
public interface userRepo extends JpaRepository<Login, Long> {
	Login findById(Long id);
	Login findByUserid(String userid);
}
