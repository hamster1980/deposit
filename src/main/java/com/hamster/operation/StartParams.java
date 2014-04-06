package com.hamster.operation;

import com.hamster.model.OperationRole;
import com.hamster.model.PaymentCondition;
import com.hamster.model.Type;

public interface StartParams {

    Type getType();

    long getAuthor();

    OperationRole getAuthorRole();

    PaymentCondition getPaymentCondition();

}
