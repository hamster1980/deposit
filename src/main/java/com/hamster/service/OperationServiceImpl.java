package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.hamster.model.Operation;
import com.hamster.model.OperationStateEnum;
import com.hamster.model.OperationTypeEnum;
import com.hamster.repository.OperationRepository;

@Service("operationService")
@Transactional
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationRepository repository;
	@Autowired
	private OperationParticipantService participantService; 

	@Override
	public Operation getOperation(Integer key) {
		return repository.findOne(key);
	}
	
	@Override
	public Operation start(StartParams params) {
		Preconditions.checkNotNull(params);
		Operation operation = new Operation();
		operation.setPaymentCondition(params.getPaymentCondition());
		operation.setState(OperationStateEnum.INITED);
		operation.setType((OperationTypeEnum) params.getType());
		operation = repository.saveAndFlush(operation);
		participantService.addParticipant(operation.getId(), params.getAuthor(), params.getAuthorRole());
		return operation;
	}

}
