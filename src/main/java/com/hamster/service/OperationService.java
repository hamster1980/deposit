package com.hamster.service;

import com.hamster.model.Operation;
import com.hamster.operation.StartParams;

public interface OperationService {

	Operation getOperation(long key);
	
	Operation start(StartParams params);
	
}
