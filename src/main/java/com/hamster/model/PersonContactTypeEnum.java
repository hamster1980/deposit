package com.hamster.model;

import java.io.Serializable;

public enum PersonContactTypeEnum implements Type {
	EMAIL,
	PHONE,
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
