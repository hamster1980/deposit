package com.hamster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hamster.model.Key;
import com.hamster.model.OperationParticipant;

@Repository
public interface OperationParticipantRepository extends CrudRepository<OperationParticipant, Key> {

}
