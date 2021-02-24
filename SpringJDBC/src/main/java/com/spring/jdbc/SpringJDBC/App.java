package com.spring.jdbc.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entites.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // java Annotation Configuration
        
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
       StudentDaoImpl studentDao= context.getBean("studentimple",StudentDaoImpl.class);
        
        //XML Configuration 
       /* ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/SpringJDBC/config-jdbc.xml");
        StudentDao studentDao=context.getBean("studentimple", StudentDao.class);*/
        //Insert 
      /*Student s=new Student();
        s.setId(109);
        s.setName("Varadha Kasture");
        s.setCity("Nagapur");
       int result= studentDao.insert(s);
       System.out.println("Number of record inserted :"+result);*/
       
       //update 
      
       /*  
        Student s1=new Student();
        s1.setId(4);
        s1.setName("Mahesh Sartape");
        s1.setCity("Delhi");
        int result=studentDao.updateStudent(s1);
        System.out.println("number of records updated "+result);*/
        
		// Delete
		 /* int result=studentDao.deleteStudent(4);
		  System.out.println("no of records deleted .."+result);
		  */
		 
        // single record retrieval 
/*       Student newStudent= studentDao.getStudent(101);
       System.out.println(newStudent);*/
       
       System.out.println("list of students");
      List<Student> listOfStudents= studentDao.getAllStudents();
    for(Student student : listOfStudents) {
    	System.out.println(student);
    }
    }
}
