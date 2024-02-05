package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOimpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//CreateStudent(studentDAO);
			//create single student 
			
			// for creating multiple students
			createMultiplestudents(studentDAO);
		};
	}

	private void createMultiplestudents(StudentDAO studentDAO) {
		Student tempStudent1 =new Student("John", "Doe","Johndoe@gmail.com");
		Student tempStudent2 =new Student("pope", "chopoe","poppeeopee@gmail.com");
		Student tempStudent3 =new Student("agyi", "agyo","agyieoa@gmail.com");
		System.out.println("saving  student objects...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void CreateStudent(StudentDAO studentDAO) {
	//create the student object
System.out.println("creating new student object...");

Student tempStudent =new Student("Paul", "Doe","doe@gmail.com");
		// save the student object
		System.out.println("saving the student object...");
		studentDAO.save(tempStudent);
		System.out.println("saved student generated id:"+tempStudent.getId());

		// display id of the saved student object


	}


}
