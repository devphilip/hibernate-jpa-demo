package com.devphilip.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devphilip.jpa.hibernate.demo.entity.Employee;
import com.devphilip.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.devphilip.jpa.hibernate.demo.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private static final Logger log = LoggerFactory.getLogger(EmployeeRepository.class);

	@Autowired
	EntityManager em;

	// insert an employee
	public Employee insert(Employee employee) {
		if (employee.getId() == null) {
			em.persist(employee);
		} else {
			em.merge(employee);
		}
		return employee;
	}

	public List<PartTimeEmployee> retrievePartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	public List<FullTimeEmployee> retrieveFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}

	public void deleteById(Long id) {
		Employee employee = findById(id);
		em.remove(employee);
	}

}
