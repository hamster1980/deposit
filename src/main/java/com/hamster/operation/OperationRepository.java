package com.hamster.operation;

import org.springframework.data.repository.CrudRepository;

import com.hamster.model.Key;
import com.hamster.model.Operation;

public interface OperationRepository extends CrudRepository<Operation, Key>{

}
