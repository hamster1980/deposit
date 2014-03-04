package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.model.Operation;
import com.hamster.model.OperationParticipant;
import com.hamster.model.PaymentCondition;
import com.hamster.operation.OperationRepository;

@Service("operationService")
@Transactional
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationRepository repository;
	@Autowired
	private OperationParticipantService participantService; 
	
	@Override
	public Operation start(PaymentCondition paymentCondition, OperationParticipant author) {
		Operation operation = new Operation();
		operation.setPaymentCondition(paymentCondition);
		operation = repository.save(operation);
		author.setOperationKey(operation.getKey());
		participantService.addParticipant(author);
		return operation;
	}

}
