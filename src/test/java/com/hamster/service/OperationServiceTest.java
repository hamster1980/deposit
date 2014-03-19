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
import com.hamster.model.OperationStateEnum;
import com.hamster.model.OperationTypeEnum;
import com.hamster.model.PaymentCondition;
import com.hamster.model.State;
import com.hamster.model.Type;
import com.hamster.service.OperationService.StartParams;
import com.hamster.test.annotation.DataSets;

@DataSets(setUpDataSet="/com/hamster/service/TestData.xls")
public class OperationServiceTest extends AbstractServiceTest{
/*
 * start operation
 * 1. unexisted person
 * 2. correct start. check state, operation key, 
 * 3. amount constraints
 */
	@Autowired
	private OperationService service;

	@Test
	@DataSets(setUpDataSet="/com/hamster/service/OperationServiceGetOperation.xls")
	public void testGetOperation() {
		Operation operation = service.getOperation(1);
		assertNotNull(operation);
		operation = service.getOperation(2);
		assertNull(operation);
	}
	
	@Test
	public void testStart() {
		final PaymentCondition condition = new PaymentCondition()
											.setFullAmount(Amount.create("100.56", Currency.getInstance("RUB")));
		final Type type = OperationTypeEnum.FLAT_RENTING;
		Operation operation = service.start(
								new StartParams() {
									@Override
									public Type getType() {
										return type;
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
		checkOperation(operation, condition.getFullAmount(), OperationStateEnum.STARTED, type);
		checkOperation(emf.find(Operation.class, operation.getId()), condition.getFullAmount(), OperationStateEnum.STARTED, type);
		List<OperationParticipant> participants = emf.createNativeQuery("select * from OPERATION_PARTICIPANT where operation_id = " + operation.getId(), OperationParticipant.class).getResultList();
		assertTrue(participants != null && participants.size() == 1);
		OperationParticipant author = Iterables.getFirst(participants, null);
		assertNotNull(author.getPerson());
		assertTrue(author.getPerson().getId() == 1L);
	}
	
	private void checkOperation(Operation operation, Amount expectedAmount, State expectedState, Type expectedType) {
		assertNotNull(operation);
		assertNotNull(operation.getId());
		assertEquals(expectedState, operation.getState());
		assertEquals(expectedType, operation.getType());
		assertNotNull(operation.getCreationDate());
		assertNotNull(operation.getPaymentCondition());
		assertEquals(expectedAmount, operation.getPaymentCondition().getFullAmount());
	}
}
