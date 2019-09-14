package com.devphilip.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devphilip.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	private static final Logger log = LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	// playing with EntityManager
		public void playWithEntityManager() {
			Course course1 = new Course("Web Services in 100 Steps");
			em.persist(course1);
			
			Course course2 = findById(10001L);
			course2.setName("JPA Demo - Updated");
			em.persist(course2);

		}
	
//	// playing with EntityManager
//	public void playWithEntityManager() {
//		Course course1 = new Course("Web Services in 100 Steps");
//		em.persist(course1);
//		Course course2 = new Course("Angular in 100 Steps");
//		em.persist(course2);
//		em.flush();  
//		/*
//		 * em.clear(); 
//		 * em.detach(course1); 
//		 * em.detach(course2);
//		 */
//		course1.setName("Web Services in 100 Steps - updated");
//		course2.setName("Angular in 100 Steps - updated");
//		em.flush();
//		
//		em.refresh(course1);
//	}

}
