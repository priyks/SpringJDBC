package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entites.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();

}
