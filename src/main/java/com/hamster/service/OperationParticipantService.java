package com.hamster.service;

import com.hamster.model.OperationParticipant;
import com.hamster.model.OperationRole;

public interface OperationParticipantService {

	OperationParticipant addParticipant(Integer operation, Integer person, OperationRole role);
	
}
