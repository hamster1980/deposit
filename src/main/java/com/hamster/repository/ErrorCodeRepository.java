package com.hamster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamster.model.ErrorCode;

@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCode, Long> {

	ErrorCode findByType(String type);
	
}
