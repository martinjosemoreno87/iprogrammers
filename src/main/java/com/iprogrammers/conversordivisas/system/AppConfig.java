package com.iprogrammers.conversordivisas.system;

import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	
	/*
	 * POSTGRESQL
	 */
	@Bean("dataSource")
	public DataSource getDataSource() {

		return DataSourceBuilder
					.create()
					.driverClassName("org.postgresql.Driver")
					.url("jdbc:postgresql://localhost:5432/cotizaciones")
					.username("iprogrammers")
					.password("iprogrammers1234")
					.build();
	}
	
	@Bean("sessionfactory")
	public SessionFactory getSessionfactory(DataSource dataSource) {
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.default_schema", "iprogrammers");
		properties.put("hibernate.jdbc.lob.non_contextual_creation", true);
		
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.scanPackages("com.iprogrammers.conversordivisas.model");
		sessionFactoryBuilder.addProperties(properties);
		return sessionFactoryBuilder.buildSessionFactory();
	}

	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("sessionfactory") SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	

	@Bean("myKey")
	public String getMyKey() {
		return "{AGREGAR KEY}";
	}
	
	@Bean("restEntity")
	public HttpEntity<String> getHeaders() {
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
        		+ "Chrome/54.0.2840.99 Safari/537.36");
        
        
        return new HttpEntity<String>("parameters", headers);
        
	}
}
