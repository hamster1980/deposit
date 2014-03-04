package com.hamster.operation;

import org.springframework.data.repository.CrudRepository;

import com.hamster.model.Key;
import com.hamster.model.OperationParticipant;

public interface OperationParticipantRepository extends CrudRepository<OperationParticipant, Key> {

}
