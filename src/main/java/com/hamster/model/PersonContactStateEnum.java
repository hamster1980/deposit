package com.hamster.model;

public enum PersonContactStateEnum implements State {
	WAITED,
	CONFIRMED,
	REMOVED
	;

	@Override
	public Key getKey() {
		return Enums.getKey(this);
	}

}
