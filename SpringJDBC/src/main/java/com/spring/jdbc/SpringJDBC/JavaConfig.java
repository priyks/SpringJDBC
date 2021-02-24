package com.spring.jdbc.SpringJDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages="com.spring.jdbc.dao")
public class JavaConfig {

	@Bean("ds")
	public DriverManagerDataSource getDriverManager() {
		DriverManagerDataSource driver=new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driver.setUrl("jdbc:mysql://localhost:9090/java");
		driver.setUsername("root");
		driver.setPassword("12@SyZip");
	
		return driver;
	}
	@Bean(name= {"jdbc-template"})
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManager());
		return jdbcTemplate;
		
	}
	
	/*@Bean(name= {"studentimple"})
	public StudentDaoImpl getStudentImpl() {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		studentDao.setJdbcTemplate(getJdbcTemplate());
		return studentDao;
		
	}
*/}
