package com.hamster.error;

import com.google.common.base.Preconditions;
import com.hamster.model.ErrorCode;

public class ErrorCodeException extends ApplicationException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE_PREFIX = "error.code.";
	
	private final ErrorCode error;
	
	public ErrorCodeException(ErrorCode error) {
		super("Exception with " + error);
		this.error = Preconditions.checkNotNull(error);
	}

	@Override
	public String getDefaultMessage() {
		return error.getDefautMessage();
	}

	@Override
	public String getCode() {
		return MESSAGE_PREFIX + error.getId();
	}

	public ErrorCode getError() {
		return error;
	}


}
