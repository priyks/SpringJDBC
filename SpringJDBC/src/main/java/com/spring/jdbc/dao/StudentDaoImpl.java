package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;
@Component("studentimple")
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student(sid,sname,scity) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int updateStudent(Student student) {
		String query = "update student set sname=? , scity=? where sid=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int deleteStudent(int studentId) {
	String query="delete from student where sid=?";
	int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}

	public Student getStudent(int studentId) {
	 String query="select * from student where sid=?";
	 RowMapper<Student> rowMapper=new RowMapperImpl();
	 Student stud=(Student) this.jdbcTemplate.queryForObject(query, rowMapper,studentId ); 
	 return stud;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		 String query="select * from student";
		 List<Student> students=this.jdbcTemplate.query(query,new  RowMapperImpl());
		return students;
	}

}
