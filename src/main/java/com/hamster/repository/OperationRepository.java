package com.hamster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hamster.model.Operation;
import com.hamster.model.StringKey;

@Repository
public interface OperationRepository extends CrudRepository<Operation, StringKey>{

}
