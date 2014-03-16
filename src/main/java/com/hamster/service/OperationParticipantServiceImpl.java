package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.model.Operation;
import com.hamster.model.OperationParticipant;
import com.hamster.model.OperationParticipantStateEnum;
import com.hamster.model.OperationRole;
import com.hamster.model.OperationRoleEnum;
import com.hamster.model.Person;
import com.hamster.repository.OperationParticipantRepository;

@Service("operationParticipantService")
@Transactional
public class OperationParticipantServiceImpl implements OperationParticipantService {

	@Autowired
	private OperationParticipantRepository repository;

	@Override
	public OperationParticipant addParticipant(long operation, long person, OperationRole role) {
		OperationParticipant participant = new OperationParticipant();
		participant.setOperation(new Operation(operation));
		participant.setPerson(new Person(person));
		participant.setRole((OperationRoleEnum) role);
		participant.setState(OperationParticipantStateEnum.WAITED);
		return repository.save(participant);
	}

}
