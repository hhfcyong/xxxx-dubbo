package com.xxxx.service.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

	@Bean(name="firstDataSource")
	@Qualifier("firstDataSource")
	@ConfigurationProperties(prefix="spring.datasource.first")
	public DataSource firstDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="secondDataSource")
	@Qualifier("secondDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.second")
	public DataSource secondDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "firstJdbcTemplate")
	public JdbcTemplate firstJdbcTemplate(
	        @Qualifier("firstDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	@Bean(name = "secondJdbcTemplate")
	public JdbcTemplate secondJdbcTemplate(
	        @Qualifier("secondDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
