package com.devphilip.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devphilip.jpa.hibernate.demo.entity.Course;

@Repository
//@RepositoryRestResource(path="/courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByName(String name);

	List<Course> findByNameAndId(String name, Long id);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

	// PSQL Query
	@Query("Select c From Course c where name like '%100 steps'")
	List<Course> coursesWith100StepsInName();

	// Native Query
	@Query(value = "Select * From Course where name like '%100 steps'", nativeQuery = true)
	List<Course> coursesWith100StepsInNameUsingNativeQuery();

	// Named Query
//	@Query(name = "query_get_demo_courses")
//	List<Course> coursesWithDemoUsingNamedQuery();

}
	