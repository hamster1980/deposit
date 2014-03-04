package com.hamster.model;

public enum OperationRoleEnum implements OperationRole {
	PAYER,
	MEDIATOR,
	CLAIMANT
	;

	@Override
	public Key getKey() {
		return Enums.getKey(this);
	}

}
