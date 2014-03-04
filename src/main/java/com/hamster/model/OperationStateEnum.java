package com.hamster.model;

public enum OperationStateEnum implements State {
	INITED,
	;

	@Override
	public Key getKey() {
		return Enums.getKey(this);
	}

}
