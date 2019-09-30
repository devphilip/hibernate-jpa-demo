package com.devphilip.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devphilip.jpa.hibernate.demo.JpaHibernateDemoApplication;
import com.devphilip.jpa.hibernate.demo.entity.Address;
import com.devphilip.jpa.hibernate.demo.entity.Course;
import com.devphilip.jpa.hibernate.demo.entity.Passport;
import com.devphilip.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class StudentRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(StudentRepositoryTest.class);

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
//	@Transactional
	public void someTest() {
		repository.someDummyOperation();
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student = em.find(Student.class, 20001L);
 		log.info("Student -> {}", student);
		log.info("Passport  -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void setStudentAddress() {
		Student student = em.find(Student.class, 20001L);
		student.setAddress(new Address("No 20", "Johnson Ade", "VI"));
		em.flush();
 		log.info("Student -> {}", student);
		log.info("Passport  -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndStudent() {
		Passport passport = em.find(Passport.class, 40001L);
 		log.info("Passport -> {}", passport);
		log.info("Student -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
 		log.info("Student -> {}", student);
 		log.info("Courses -> {}", student.getCourses());
	}
	
	@Test
	@Transactional
	public void retrieveCourseAndStudent() {
		Course course = em.find(Course.class, 10001L);
 		log.info("Course -> {}", course);
 		log.info("Student -> {}", course.getStudents());
	}
	
}
