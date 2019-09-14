package com.devphilip.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devphilip.jpa.hibernate.demo.JpaHibernateDemoApplication;
import com.devphilip.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class NativeQueryTest {
	
	private static final Logger log = LoggerFactory.getLogger(NativeQueryTest.class);

	@Autowired
	EntityManager em;

	@Test
	public void native_query_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		List resultList = query.getResultList();
		log.info("SELECT * FROM COURSE -> {}", resultList);
	}
	
	@Test
	public void native_query_with_parameter() {
		Query query = 
			em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		log.info("SELECT * FROM COURSE where id = ? -> {}", resultList);
	}
	
	@Test
	public void native_query_with_named_parameter() {
		Query query = 
			em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		log.info("SELECT * FROM COURSE where id = :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	public void native_query_to_update() {
		Query query = 
			em.createNativeQuery("Update COURSE set last_updated_date=sysdate()", Course.class);
		int numOfRowsUpdated = query.executeUpdate();
		log.info("Update COURSE set last_updated_date=sysdate() -> {}", numOfRowsUpdated);
	}
	
}
 