package com.hamster.model;

import java.io.Serializable;

public enum OperationErrorCodeTypeEnum implements ErrorCodeType {
    OPERATION_PERSON_DOES_NOT_EXIST, OPERATION_AMOUNT_IS_LESS_THEN_MIN, ;

    @Override
    public Serializable getId() {
        return Enums.getKey(this);
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
