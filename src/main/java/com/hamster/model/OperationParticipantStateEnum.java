package com.hamster.model;

import java.io.Serializable;

public enum OperationParticipantStateEnum implements State {
    WAITED, CONFIRMED, ;

    @Override
    public Serializable getId() {
        return Enums.getKey(this);
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
