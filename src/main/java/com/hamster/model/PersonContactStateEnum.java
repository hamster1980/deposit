package com.hamster.model;

import java.io.Serializable;

public enum PersonContactStateEnum implements State {
	WAITED,
	CONFIRMED,
	REMOVED
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
