package com.hamster.service;

import com.hamster.model.OperationParticipant;
import com.hamster.model.OperationRole;

public interface OperationParticipantService {

    OperationParticipant addParticipant(long operation, long person,
            OperationRole role);

}
