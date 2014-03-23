package com.hamster.service;

import com.hamster.model.ErrorCode;
import com.hamster.model.ErrorCodeType;

public interface ErrorCodeService {

	ErrorCode getByType(ErrorCodeType type);
	
}
