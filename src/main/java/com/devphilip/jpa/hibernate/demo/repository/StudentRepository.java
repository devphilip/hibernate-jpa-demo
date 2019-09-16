package com.devphilip.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devphilip.jpa.hibernate.demo.entity.Course;
import com.devphilip.jpa.hibernate.demo.entity.Passport;
import com.devphilip.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private static final Logger log = LoggerFactory.getLogger(StudentRepository.class);

	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		Student course = findById(id);
		em.remove(course);
	}

	// playing with EntityManager
	public void saveStudentWithPassport() {
		Passport passport = new Passport("E1234504");
		em.persist(passport);

		Student student = new Student("David");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void someDummyOperation() {
		// Database operation 1 Retrieve student
		Student student = em.find(Student.class, 20001l);
		
		// Database operation 2 Retrieve passport
		Passport passport = student.getPassport();
		
		// Database operation  update passport
		passport.setNumber("E12345001");
		
		// Database operation 1 update student
		student.setName("James - Updated");
	}
	
	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Morris");
		Course course = new Course("Microservices in 100 Steps");
		em.persist(student);
		em.persist(course);
		student.addCourses(course);
		course.addStudents(student);
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		student.addCourses(course);
		course.addStudents(student);
		em.persist(student);
		em.persist(course);
	}


}
