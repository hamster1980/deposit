package com.hamster.service;

import com.hamster.model.Operation;
import com.hamster.model.OperationParticipant;
import com.hamster.model.PaymentCondition;

public interface OperationService {

	Operation start(PaymentCondition paymentCondition, OperationParticipant author);
	
}
