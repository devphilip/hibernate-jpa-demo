insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10001, 'JPA in 50 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10002, 'JPA Demo by in28Min', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10003, 'JPA Demo with JUnit', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10004, 'Spring MicroServices in 100 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10005, 'Java for beginers in 250 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10006, 'Database design in 50 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10007, 'Servlet and JSP in 25 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10008, 'Spring in 50 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10009, 'Spring boot in 100 steps', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
			values(10010, 'Eclipse in 20 steps', sysdate(), sysdate(), false);

			
insert into passport(id, number) values(40001, 'E1234501');	
insert into passport(id, number) values(40002, 'E1234502');	
insert into passport(id, number) values(40003, 'E1234503');	

insert into student(id, name, passport_id) values(20001, 'James', 40001);
insert into student(id, name, passport_id) values(20002, 'John', 40002);			
insert into student(id, name, passport_id) values(20003, 'Joseph', 40003);

insert into review(id, rating, description, course_id) values(50001, 'FIVE', 'Great Course', 10001);	
insert into review(id, rating, description, course_id) values(50002, 'FOUR', 'Good Course', 10001);	
insert into review(id, rating, description, course_id) values(50003, 'FIVE', 'Awesome Course', 10003);	

--insert into review(id, rating, description, course_id) values(50001, 5, 'Great Course', 10001);	
--insert into review(id, rating, description, course_id) values(50002, 4, 'Good Course', 10001);	
--insert into review(id, rating, description, course_id) values(50003, 5, 'Awesome Course', 10003);	

insert into student_course(student_id, course_id) values(20001, 10001);
insert into student_course(student_id, course_id) values(20002, 10001);
insert into student_course(student_id, course_id) values(20003, 10001);
insert into student_course(student_id, course_id) values(20001, 10003);

