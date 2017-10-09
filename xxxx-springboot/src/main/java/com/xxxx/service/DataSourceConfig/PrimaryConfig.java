package com.xxxx.service.DataSourceConfig;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		   entityManagerFactoryRef="entityManagerFactoryPrimary",
	        transactionManagerRef="transactionManagerPrimary",
	        basePackages= { "com.xxxx.service.Domain.Primary" } //设置Repository所在位置
)
public class PrimaryConfig {
	  @Autowired
	  @Qualifier("primaryDataSource") 
	  private DataSource primaryDataSource;
	  
	    @Primary
	    @Bean(name = "entityManagerFactoryPrimary")
	    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
	        return builder
	                .dataSource(primaryDataSource)
	                .properties(getVendorProperties(primaryDataSource))
	                .packages("com.xxxx.service.Domain.Primary") //设置实体类所在位置
	                .persistenceUnit("primaryPersistenceUnit")
	                .build();
	    }
	    @Autowired
	    private JpaProperties jpaProperties;
	    private Map<String, String> getVendorProperties(DataSource dataSource) {
	        return jpaProperties.getHibernateProperties(dataSource);
	    }
	    @Primary
	    @Bean(name = "transactionManagerPrimary")
	    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
	        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	    }
}
