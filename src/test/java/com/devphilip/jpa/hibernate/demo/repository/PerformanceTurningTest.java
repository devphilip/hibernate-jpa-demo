package com.devphilip.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.devphilip.jpa.hibernate.demo.JpaHibernateDemoApplication;
import com.devphilip.jpa.hibernate.demo.entity.Course;
import com.devphilip.jpa.hibernate.demo.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class PerformanceTurningTest {

	private static final Logger log = LoggerFactory.getLogger(PerformanceTurningTest.class);

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses", Course.class)
				.getResultList();
		for(Course course : courses) {
			log.info("Course -> {} Students -> {}", course, course.getStudents());
		}
	}
	
	@Test
	@Transactional
	public void solvingNPlusOneProblemWithEntityGraph() {
		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		entityGraph.addSubgraph("students");
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph)
				.getResultList();
		for(Course course : courses) {
			log.info("Course -> {} Students -> {}", course, course.getStudents());
		}
		
	}
	
	@Test
	@Transactional
	public void solvingNPlusOneProblemWithJoinFetch() {
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses_with_join_fetch", Course.class)
				.getResultList();
		for(Course course : courses) {
			log.info("Course -> {} Students -> {}", course, course.getStudents());
		}
	}
	
}
