package com.hamster.operation;

import java.io.Serializable;

import com.hamster.model.OperationRole;
import com.hamster.model.PaymentCondition;
import com.hamster.type.Type;

public interface StartParams extends Serializable {

    Type getType();
    
    Type getContactType();

    long getAuthor();

    OperationRole getAuthorRole();

    PaymentCondition getPaymentCondition();

}
