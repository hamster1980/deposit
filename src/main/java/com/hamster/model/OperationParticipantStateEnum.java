package com.hamster.model;

public enum OperationParticipantStateEnum implements State {
	WAITED,
	CONFIRMED,
	;
	
	@Override
	public Key getKey() {
		return Enums.getKey(this);
	}

}
