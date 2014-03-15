package com.hamster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hamster.model.OperationParticipant;
import com.hamster.model.StringKey;

@Repository
public interface OperationParticipantRepository extends CrudRepository<OperationParticipant, StringKey> {

}
