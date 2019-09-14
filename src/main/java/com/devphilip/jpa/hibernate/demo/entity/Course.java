package com.devphilip.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
		@NamedQuery(name = "query_get_demo_courses", query = "Select c From Course c where name like '%Demo'"),
})
public class Course {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	public Course() {}
	
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

	@Override
	public String toString() {
		return String.format("Course [Id=%s, name=%s]", Id, name);
	}

}
