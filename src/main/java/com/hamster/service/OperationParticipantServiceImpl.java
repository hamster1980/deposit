package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.model.OperationParticipant;
import com.hamster.operation.OperationParticipantRepository;

@Service("operationParticipantService")
@Transactional
public class OperationParticipantServiceImpl implements OperationParticipantService {

	@Autowired
	private OperationParticipantRepository repository;

	@Override
	public OperationParticipant addParticipant(OperationParticipant participant) {
		return repository.save(participant);
	}

}
