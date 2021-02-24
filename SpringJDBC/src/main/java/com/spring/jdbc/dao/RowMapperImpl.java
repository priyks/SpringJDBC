package com.spring.jdbc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student stud=new Student();
		stud.setId(rs.getInt(1));
		stud.setName(rs.getString(2));
		stud.setCity(rs.getString(3));
		return stud;
	}

}
