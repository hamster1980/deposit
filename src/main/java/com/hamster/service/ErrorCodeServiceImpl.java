package com.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamster.model.ErrorCode;
import com.hamster.model.ErrorCodeType;
import com.hamster.repository.ErrorCodeRepository;

@Service("errorCodeService")
@Transactional
public class ErrorCodeServiceImpl implements ErrorCodeService {

	@Autowired
	private ErrorCodeRepository repository;
	
	@Override
	public ErrorCode getByType(ErrorCodeType type) {
		return repository.findByType(type.toString());
	}

}
