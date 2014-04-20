package com.hamster.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import com.hamster.state.State;

public enum OperationParticipantStateEnum implements State, Persistable<Serializable> {
    WAITED, 
    CONFIRMED, 
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
