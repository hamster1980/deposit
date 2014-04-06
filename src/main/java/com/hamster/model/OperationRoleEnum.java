package com.hamster.model;

import java.io.Serializable;

public enum OperationRoleEnum implements OperationRole {
    PAYER, MEDIATOR, CLAIMANT;

    @Override
    public Serializable getId() {
        return Enums.getKey(this);
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
