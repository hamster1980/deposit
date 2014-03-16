package com.hamster.model;

import java.io.Serializable;

public enum OperationTypeEnum implements Type {
	FLAT_RENTING,
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
