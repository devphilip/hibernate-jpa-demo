package com.devphilip.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devphilip.jpa.hibernate.demo.JpaHibernateDemoApplication;
import com.devphilip.jpa.hibernate.demo.entity.Course;
import com.devphilip.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class JPQLTest {

	private static final Logger log = LoggerFactory.getLogger(JPQLTest.class);

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		log.info("Select c From Course c -> {}", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_demo_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c where name like '%Demo' -> {}", resultList);
	}
	
	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Results -> {}", resultList);
	}
	
	@Test
	public void jpql_courses_atLeast_2_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Results -> {}", resultList);
	}
	
	@Test
	public void jpql_courses_order_by_students() {
//		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students)", Course.class);
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Results -> {}", resultList);
	}

	@Test
	public void jpql_students_with_pasport_in_a_certain_pattern () {
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
		List<Student> resultList = query.getResultList();
		log.info("Results -> {}", resultList);
	}
	// like
	// BETWEEN 100 and 1000
	// IS NULL
	//upper, lower, trim length
	
	
	// JOIN => Select c, s from Course c JOIN c.students s
	// LEFT JOIN => Select c, s from Course c LEFT JOIN c.students s
	// CROSS JOIN => Select c, s from Course c, Student s
	// -> if student row=3 and course row=4, CROSS JOIN = 7 rows
	@Test
	public void join() {
		Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Results row sise -> {}", resultList.size());
		
		for (Object[] result : resultList) {
			log.info("Course -> {} Student -> {}", result[0], result[1]);
		}
	}
	
	@Test
	public void left_join() {
		Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Results row sise -> {}", resultList.size());
		
		for (Object[] result : resultList) {
			log.info("Course -> {} Student -> {}", result[0], result[1]);
		}
	}
	
	@Test
	public void cross_join() {
		Query query = em.createQuery("Select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		log.info("Results row sise -> {}", resultList.size());
		
		for (Object[] result : resultList) {
			log.info("Course -> {} Student -> {}", result[0], result[1]);
		}
	}	
	
	
	
	

}






