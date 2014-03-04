package com.hamster.model;

public enum OperationTypeEnum implements Type {
	FLAT_RENTING,
	;

	@Override
	public Key getKey() {
		return Enums.getKey(this);
	}

}
