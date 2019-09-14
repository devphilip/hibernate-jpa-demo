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
		TypedQuery<Course> query = 
			em.createNamedQuery("query_get_demo_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c where name like '%Demo' -> {}", resultList);
	}
	
}
