package com.devphilip.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devphilip.jpa.hibernate.demo.entity.Course;
import com.devphilip.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(JpaHibernateDemoApplication.class);
	
	@Autowired
	private CourseRepository courseRepository; 

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		
		log.info("{}", course);
		
		courseRepository.save(new Course("MicroServices Indept"));
	}

}
