package com.hamster.service;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ImportResource({"classpath:spring/datasource.xml", "classpath:spring/tx-jpa.xml"})
@ComponentScan(basePackages={"com.hamster.service"})
@Profile("test")
public class TestConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
					.addScript("classpath:db/common-schema.sql")
					.addScript("classpath:db/schema.sql")
					.addScript("classpath:db/operation-data.sql")
					.addScript("classpath:db/data.sql")
						.build();
	}
	
	@Bean(name="databaseTester")
	public DataSourceDatabaseTester dataSourceDatabaseTester() {
		return new DataSourceDatabaseTester(dataSource());
	}
	
	@Bean(name="xlsDataFileLoader")
	public XlsDataFileLoader xlsDataFileLoader() {
		return new XlsDataFileLoader();
	}
}
