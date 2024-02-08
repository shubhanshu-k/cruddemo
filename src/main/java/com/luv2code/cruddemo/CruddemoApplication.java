package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOimpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//CreateStudent(studentDAO);
			//create single student 
//			readStudent(studentDAO);
			// for creating multiple students
//			createMultiplestudents(studentDAO);

//		  queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retreive student based on id: primary key
		// change first name to "scooby"
		// update the student
		// display the updated student
		int studentId = 1;
		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findById(studentId);
		myStudent.setFirstName("scooby");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
	// get a list of students//
		// display list of students//
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
 // get a list of students


		List<Student>theStudents = studentDAO.findAll();
      // display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
 Student tempStudent = new Student( "champa", "rani", "rani@gmail.com");

 studentDAO.save(tempStudent);
 int theId = tempStudent.getId();
		System.out.println("id is"+ theId);

 Student myStudent = studentDAO.findById(theId);
		System.out.println("student is"+ myStudent);
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
