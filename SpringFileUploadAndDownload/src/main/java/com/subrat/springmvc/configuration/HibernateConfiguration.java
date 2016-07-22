package com.subrat.springmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.subrat.springmvc.configuration")
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactoryBean= new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setPackagesToScan(new String [] {"com.subrat.springmvc.model"});
		
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		 dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	     dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	     dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	     dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	     return dataSource;
		
	}
	
	private Properties hibernateProperties(){
		Properties props= new Properties();
		props.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		props.put("hibernate.show_sql",environment.getRequiredProperty("hibernate.show_sql"));
		props.put("hibernate.format_sql",environment.getRequiredProperty("hibernate.format_sql"));
		return props;
		
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager hibernateTxnMgr= new HibernateTransactionManager();
		hibernateTxnMgr.setSessionFactory(sessionFactory);
		return hibernateTxnMgr;
	}

}
