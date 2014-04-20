package com.hamster.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import com.hamster.state.State;

public enum OperationStateEnum implements State, Persistable<Serializable> {
    STARTED, 
    WORKING, 
    FINISHED, 
    ;

    @Override
    public Serializable getId() {
        return Enums.getKey(this);
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
