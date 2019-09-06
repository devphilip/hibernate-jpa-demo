package com.devphilip.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String name;

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

	@Override
	public String toString() {
		return String.format("Course [Id=%s, name=%s]", Id, name);
	}

}
