package com.hamster.service;

import java.util.Collection;

import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableSet;

@Configuration
public class TestConfig extends AServiceTestConfig {

	@Override
	protected Collection<String> getScripts() {
		return ImmutableSet.of("classpath:db/common-schema.sql"
		                        , "classpath:db/person-schema.sql"
		                        , "classpath:db/person-data.sql"
		                        , "classpath:db/confirmation-schema.sql"
		                        , "classpath:db/confirmation-data.sql"
		                        , "classpath:db/operation-schema.sql"
		                        , "classpath:db/operation-data.sql"
								
		);
	}
}
