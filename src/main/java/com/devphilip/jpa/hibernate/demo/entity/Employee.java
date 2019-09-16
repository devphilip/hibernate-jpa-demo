package com.devphilip.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "EmployeeType")
@MappedSuperclass
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long Id;

	@Column(nullable = false)
	private String name;

	public Employee() {
	}

	public Employee(String name) {
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
		return String.format("Course [name=%s]", name);
	}

}
