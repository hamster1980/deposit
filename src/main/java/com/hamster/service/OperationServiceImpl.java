package com.hamster.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.hamster.confirmation.ConfirmParams;
import com.hamster.confirmation.SimpleSendParams;
import com.hamster.error.Utils;
import com.hamster.model.Amount;
import com.hamster.model.Operation;
import com.hamster.model.OperationErrorCodeTypeEnum;
import com.hamster.model.OperationStateEnum;
import com.hamster.model.OperationTypeEnum;
import com.hamster.operation.StartParams;
import com.hamster.repository.OperationRepository;

@Service("operationService")
@Transactional
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository repository;
    @Autowired
    private OperationParticipantService participantService;
    @Autowired
    private ErrorCodeService errorCodeService;
    @Autowired
    private ConfirmationService confirmationService;

    @Override
    public Operation getOperation(long key) {
        return repository.findOne(key);
    }

    @Override
    public Operation start(final StartParams params) {
        Preconditions.checkNotNull(params);
        Preconditions.checkNotNull(params.getPaymentCondition());
        Amount amount = params.getPaymentCondition().getFullAmount();
        if (amount.isEmpty() || !amount.isSign()) {
            Utils.throwErrorCodeException(
                    errorCodeService,
                    OperationErrorCodeTypeEnum.OPERATION_AMOUNT_IS_LESS_THEN_MIN);
        }
        Operation operation = new Operation();
        operation.setPaymentCondition(params.getPaymentCondition());
        operation.setState(OperationStateEnum.STARTED);
        operation.setType((OperationTypeEnum) params.getType());
        operation.setCreationDate(DateTime.now());
        operation = repository.saveAndFlush(operation);
        participantService.addParticipant(operation.getId(), params.getAuthor(), params.getAuthorRole());
        confirmationService.create(new SimpleSendParams(params.getAuthor(), params.getContactType(), operation.getId()));
        return operation;
    }

    @Override
    public void confirmStart(ConfirmParams params) {
    }

}
