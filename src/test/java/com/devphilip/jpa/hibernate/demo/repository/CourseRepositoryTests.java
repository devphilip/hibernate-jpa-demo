package com.devphilip.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class CourseRepositoryTests {
	
	private static final Logger log = LoggerFactory.getLogger(CourseRepositoryTests.class);

	@Autowired
	CourseRepository repository;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L); 
		assertEquals("JPA Demo", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		// Get a course 
		Course course = repository.findById(10001L); 
		assertEquals("JPA Demo", course.getName());
		
		// Update the name
		course.setName("JPA Demo - Updated");
		
		repository.save(course);
		
		// Check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA Demo - Updated", course1.getName());
		
		
	}

}
