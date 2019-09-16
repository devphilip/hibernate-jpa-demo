package com.devphilip.jpa.hibernate.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devphilip.jpa.hibernate.demo.entity.Course;
import com.devphilip.jpa.hibernate.demo.entity.Employee;
import com.devphilip.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.devphilip.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.devphilip.jpa.hibernate.demo.entity.Student;
import com.devphilip.jpa.hibernate.demo.repository.CourseRepository;
import com.devphilip.jpa.hibernate.demo.repository.EmployeeRepository;
import com.devphilip.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(JpaHibernateDemoApplication.class);
	
	@Autowired
	private CourseRepository courseRepository; 
	@Autowired
	private StudentRepository studentRepository;  
	@Autowired
	private EmployeeRepository employeeRepository;  

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		studentRepository.saveStudentWithPassport();
//		Course course = courseRepository.findById(10001L);
//		
//		log.info("{}", course);
//		
//		courseRepository.save(new Course("MicroServices Indept"));
		
		//		courseRepository.playWithEntityManager();
//		courseRepository.addHardCodedReviewsForCourse();
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Greate Hands-on course"));
//		reviews.add(new Review("5", "Greate Hands-on stuff"));
//		courseRepository.addReviewsForCourse(10003L, reviews);
		
//		studentRepository.insertHardCodedStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("Morris"), new Course("Microservices in 100 Steps"));
		
		FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Micheal", new BigDecimal("5000"));
		employeeRepository.insert(fullTimeEmployee);
		log.info("EmployeeRepository Retrieve PartTimeEmployees => {}", employeeRepository.retrievePartTimeEmployees());
		
		PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jim", new BigDecimal("50"));
		employeeRepository.insert(partTimeEmployee);
		log.info("EmployeeRepository Retrieve FullTimeEmployees => {}", employeeRepository.retrievePartTimeEmployees());
		
	}

}
