package com.hamster.model;

import java.io.Serializable;

public enum OperationStateEnum implements State {
    STARTED, WORKING, FINISHED, ;

    @Override
    public Serializable getId() {
        return Enums.getKey(this);
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
