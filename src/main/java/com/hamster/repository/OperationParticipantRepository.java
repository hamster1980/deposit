package com.hamster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamster.model.OperationParticipant;

@Repository
public interface OperationParticipantRepository extends JpaRepository<OperationParticipant, Integer> {

}
