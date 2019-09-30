package com.devphilip.jpa.hibernate.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.devphilip.jpa.hibernate.demo.JpaHibernateDemoApplication;
import com.devphilip.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CourseSpringDataRepositoryTest.class);

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById_coursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_courseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}
	
	@Test
	public void findById_playingWithSpringDataJpa() {
//		Course course = new Course("Microservices in 100 Steps");
//		repository.save(course);
//		 
//		course.setName("Microservices in 100 - updated");
//		repository.save(course);
		
		log.info("Courses -> {}", repository.findAll());
		log.info("Courses count -> {}", repository.count());
		
	}
	
	@Test
	public void sort() {
		Sort sort = new Sort(Sort.Direction.DESC, "name");
		
		log.info("Sorted Courses -> {}", repository.findAll(sort));
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = repository.findAll(pageRequest);
		log.info("First Courses Page -> {}", firstPage.getContent());
		
		Pageable  secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		log.info("Second Courses Page -> {}", secondPage.getContent());
		
	}
	
	@Test
	public void findUsingName() {
		log.info("FindByName -> {}", repository.findByName("JPA in 50 steps"));
		assertThat(repository.findByName("JPA in 50 steps"));
	}

}
