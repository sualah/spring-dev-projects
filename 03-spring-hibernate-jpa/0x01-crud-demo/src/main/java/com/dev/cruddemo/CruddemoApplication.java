package com.dev.cruddemo;

import com.dev.cruddemo.dao.StudentDAO;
import com.dev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

            //  deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRows = studentDAO.deleteAll();
		System.out.println("Deleted rows counts: " + numRows);;
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("updating student...");

		myStudent.setFirstName("John");
		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastname("Duck");

		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@demo.com");

		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "  + theId);

		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Paul", "Doe", "example@demo.com");

		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "  + tempStudent.getId());

	}
}
