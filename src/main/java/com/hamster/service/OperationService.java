package com.hamster.service;

import com.hamster.model.Operation;
import com.hamster.model.OperationRole;
import com.hamster.model.PaymentCondition;
import com.hamster.model.Type;

public interface OperationService {

	Operation getOperation(long key);
	
	Operation start(StartParams params);
	
	
	interface StartParams{
		Type getType();
		long getAuthor();
		OperationRole getAuthorRole();
		PaymentCondition getPaymentCondition();
	}
}
