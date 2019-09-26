package com.devphilip.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
		@NamedQuery(name = "query_get_demo_courses", query = "Select c From Course c where name like '%Demo'"), })
public class Course {

	@Id
	@GeneratedValue
	private Long Id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	public Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}
	
	public void removeStudents(Student student) {
		this.students.remove(student);
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

//	@Override
//	public String toString() {
//		return String.format("Course [name=%s, reviews=%s, createdDate=%s, lastUpdatedDate=%s]", name, reviews,
//				createdDate, lastUpdatedDate);
//	}
	
	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}

}
