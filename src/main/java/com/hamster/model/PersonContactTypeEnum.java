package com.hamster.model;

public enum PersonContactTypeEnum implements Type {
	EMAIL,
	PHONE,
	;

	@Override
	public Key getKey() {
		return Enums.getKey(this);
	}
	
}
