package com.hamster.service;

import static org.junit.Assert.*;

import java.util.Currency;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterables;
import com.hamster.model.Amount;
import com.hamster.model.Operation;
import com.hamster.model.OperationParticipant;
import com.hamster.model.OperationRole;
import com.hamster.model.OperationRoleEnum;
import com.hamster.model.OperationTypeEnum;
import com.hamster.model.PaymentCondition;
import com.hamster.model.Type;
import com.hamster.service.OperationService.StartParams;
import com.hamster.test.annotation.DataSets;

public class OperationServiceTest extends AbstractServiceTest{
/*
 * start operation
 * 1. unexisted person
 * 2. correct start. check state, operation key, 
 * 3. amount constraints
 */
	@Autowired
	private OperationService service;

	@DataSets(setUpDataSet="/com/hamster/service/TestData.xls")
	@Test
	public void testStart() {
		final PaymentCondition condition = new PaymentCondition();
		condition.setFullAmount(Amount.create("100.56", Currency.getInstance("RUB")));
		Operation operation = service.start(
								new StartParams() {
									@Override
									public Type getType() {
										return OperationTypeEnum.FLAT_RENTING;
									}
									@Override
									public long getAuthor() {
										return 1;
									}
									@Override
									public OperationRole getAuthorRole() {
										return OperationRoleEnum.MEDIATOR;
									}
									@Override
									public PaymentCondition getPaymentCondition() {
										return condition;
									}
								}
		);
		emf.flush();
		assertNotNull(operation);
		operation = emf.find(Operation.class, operation.getId());
		assertNotNull(operation);
		List<OperationParticipant> participants = emf.createNativeQuery("select * from OPERATION_PARTICIPANT where operation_id = " + operation.getId(), OperationParticipant.class).getResultList();
		assertTrue(participants != null && participants.size() == 1);
		OperationParticipant author = Iterables.getFirst(participants, null);
		assertTrue(author.getPerson().getId() == 1L);
		//todo: check state of participant and operation
	}
}
