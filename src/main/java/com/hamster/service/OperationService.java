package com.hamster.service;

import org.springframework.security.access.annotation.Secured;

import com.hamster.model.Operation;
import com.hamster.operation.StartParams;

public interface OperationService {

    String CREATE_OPERATION_GRAND = "ROLE_CREATE_OPERATION";
    
    Operation getOperation(long key);

    @Secured(OperationService.CREATE_OPERATION_GRAND)
    Operation start(StartParams params);

}
