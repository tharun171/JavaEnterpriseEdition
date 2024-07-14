package com.learn.springfrm.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:com/learn/springfrm/resources/connection.properties")
public class SpringConfigJava {
	
	@Value("${driverName}")
	private String driverName;
	@Value("${url}")
	private String DBurl;
	@Value("${user}")
	private String username;
	@Value("${password}")
	private String password;
	
	//to resolve ${} in @value
	public PropertySourcesPlaceholderConfigurer propertyConfigInDev()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource()
	{
		//System.out.println(driverName+" "+DBurl);
		//System.out.println(username+" "+password);
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driverName);
		data.setUrl(DBurl);
		data.setUsername(username);
		data.setPassword(password);
		return data;
	}
	
	public HibernateJpaVendorAdapter getVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		//when database table schema or another table like sequence need to be created or added
		//then we need to set this as true
		//when doing DDL executions (data definition language) we need to give as true
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEmf(DriverManagerDataSource dataSource)
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(getVendorAdapter());
		factory.setPackagesToScan("com.learn.springfrm.Entities");
		return factory;
	}
	
	@Bean(name="txManager")
	public PlatformTransactionManager annotationDrivernTransactionManager()
	{
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(getEmf(getDataSource()).getObject());
		return tm;
	}

}
