package com.hamster.model;

import java.io.Serializable;

public enum OperationStateEnum implements State {
	INITED,
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
