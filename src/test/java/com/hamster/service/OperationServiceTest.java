package com.hamster.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationServiceTest extends AbstractServiceTest{
/*
 * start operation
 * 1. unexisted person
 * 2. correct start. check state, operation key, 
 * 3. amount constraints
 */
	@Autowired
	private OperationService service;
	
	@Test
	public void testStart() {
		service.start(null, null);
	}
}
