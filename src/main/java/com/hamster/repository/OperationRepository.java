package com.hamster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hamster.model.Key;
import com.hamster.model.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Key>{

}
