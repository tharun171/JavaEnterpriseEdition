package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:com/example/demo/resources/connection.properties")
@EnableTransactionManagement
public class SpringDBConfigJava {

	@Value("${driverClassName}")
	private String driverName;
	
	@Value("${url}")
	private String url;
	
	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String pass;
	
	//to resolve ${} in @Value
	public PropertySourcesPlaceholderConfigurer propertyConfigInDev()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driverName);
		data.setUrl(url);
		data.setUsername(user);
		data.setPassword(pass);
		return data;
	}
	
	public HibernateJpaVendorAdapter getVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
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
		factory.setPackagesToScan("com.example.demo.Entities");
		return factory;
	}
	
	@Bean(name="transactionManager")
	@Primary
	public PlatformTransactionManager annotationDrivenTransactionManager()
	{
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(getEmf(getDataSource()).getObject());
		return tm;
	}
	
	
}
