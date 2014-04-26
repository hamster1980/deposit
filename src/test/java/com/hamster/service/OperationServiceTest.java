package com.hamster.service;

import static org.junit.Assert.*;

import java.util.Currency;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.hamster.confirmation.SendParams;
import com.hamster.error.ErrorCodeException;
import com.hamster.model.Amount;
import com.hamster.model.ErrorCodeType;
import com.hamster.model.Operation;
import com.hamster.model.OperationErrorCodeTypeEnum;
import com.hamster.model.OperationParticipant;
import com.hamster.model.OperationParticipantStateEnum;
import com.hamster.model.OperationStateEnum;
import com.hamster.operation.StartParams;
import com.hamster.operation.StartParamsBuilder;
import com.hamster.state.State;
import com.hamster.test.Utils;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes={TestConfig.class})
@DataSets(setUpDataSet="/com/hamster/service/TestData.xls")
public class OperationServiceTest extends AServiceTest{

	@Autowired
	private OperationService service;

	/*
	 * confirm
	 * 1. trying to confirm when status is not STARTED
	 * 2. check status of operation after confirmation
	 * 3. check status of operation author after confirmation
	 * 4. code for entity of another type
	 * 5. check current user equals author of operation
	 */
	
	@Test
	@DataSets(setUpDataSet="/com/hamster/service/OperationServiceGetOperation.xls")
	public void testGetOperation() {
		Operation operation = service.getOperation(1);
		assertNotNull(operation);
		operation = service.getOperation(2);
		assertNull(operation);
		//todo: check mapping of existing record
	}
	
	@Test
	public void testStartForUnauthorizedUser() {
        createOperationWithException(
                StartParamsBuilder.create().build(),
                null
        );
	}

	@Test
    public void testStartForUserWithoutGrand() {
	    defaultLogin();
        createOperationWithException(
                StartParamsBuilder.create().build(),
                null
        );
    }
	
	@Test
	public void testStartWithCorrectParams() {
	    defaultLogin(OperationService.CREATE_OPERATION_GRAND);
		StartParams params = StartParamsBuilder.create().build();
		ConfirmationService confirmationService = mockConfirmationService();
		Operation operation = service.start(params);
		emf.flush();
		checkOperation(operation, params, OperationStateEnum.STARTED);
		checkOperation(emf.find(Operation.class, operation.getId()), params, OperationStateEnum.STARTED);
		List<OperationParticipant> participants = emf.createNativeQuery("select * from OPERATION_PARTICIPANT where operation_id = " + operation.getId(), OperationParticipant.class).getResultList();
		assertTrue(participants != null && participants.size() == 1);
		OperationParticipant author = Iterables.getFirst(participants, null);
		assertNotNull(author.getPerson());
		assertTrue(author.getPerson().getId() == 1L);
		assertEquals(OperationParticipantStateEnum.WAITED, author.getState());
		verify(confirmationService, times(1)).create(any(SendParams.class));
	}
	
	private ConfirmationService mockConfirmationService() {
	    ConfirmationService confirmationService = mock(ConfirmationService.class);
	    try {
            ReflectionTestUtils.setField(Utils.unwrapProxy(service, OperationService.class), "confirmationService", confirmationService);
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
	    return confirmationService;
	}
	
	@Test
	public void testStartForUnexistedPerson() {
	    defaultLogin(OperationService.CREATE_OPERATION_GRAND);
		//todo: check that there no any new records in database
		createOperationWithException(
				StartParamsBuilder.create()
					.author(2)
					.build(),
				null
		);
	}

	@Test
	public void testStartForIncorrectAmount() {
	    defaultLogin(OperationService.CREATE_OPERATION_GRAND);
		for(Entry<Amount, OperationErrorCodeTypeEnum> entry : ImmutableMap.of(
												Amount.create(Currency.getInstance("RUB")), OperationErrorCodeTypeEnum.OPERATION_AMOUNT_IS_LESS_THEN_MIN
												, Amount.create("-1", Currency.getInstance("RUB")), OperationErrorCodeTypeEnum.OPERATION_AMOUNT_IS_LESS_THEN_MIN
												//todo: max value
										  	).entrySet()) {
			createOperationWithException(
					StartParamsBuilder.create()
						.amount(entry.getKey())
						.build(),
					entry.getValue()
			);
		}
	}
	
	private void createOperationWithException(StartParams params, ErrorCodeType errorType) {
		try {
			service.start(params);
			assertTrue(false);
		} catch(Exception e) {
			if(errorType != null) {
				assertTrue(e instanceof ErrorCodeException && ((ErrorCodeException)e).getError().getType().equals(errorType.toString()));
			}
		}
	}
	
	private void checkOperation(Operation operation, StartParams params, State expectedState) {
		assertNotNull(operation);
		assertNotNull(operation.getId());
		assertEquals(expectedState, operation.getState());
		assertEquals(params.getType(), operation.getType());
		assertNotNull(operation.getCreationDate());
		assertNotNull(operation.getPaymentCondition());
		assertEquals(params.getPaymentCondition().getFullAmount(), operation.getPaymentCondition().getFullAmount());
	}
	
}
