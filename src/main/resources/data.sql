insert into course(id, name, created_date, last_updated_date) 
			values(10001, 'JPA Demo', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
			values(10002, 'JPA Demo by in28Min', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
			values(10003, 'JPA Demo with JUnit', sysdate(), sysdate());
			
insert into passport(id, number) values(40001, 'E1234501');	
insert into passport(id, number) values(40002, 'E1234502');	
insert into passport(id, number) values(40003, 'E1234503');	

insert into student(id, name, passport_id) values(20001, 'James', 40001);
insert into student(id, name, passport_id) values(20002, 'John', 40002);			
insert into student(id, name, passport_id) values(20003, 'Joseph', 40003);

insert into review(id, rating, description, course_id) values(50001, '5', 'Great Course', 10001);	
insert into review(id, rating, description, course_id) values(50002, '4', 'Good Course', 10001);	
insert into review(id, rating, description, course_id) values(50003, '5', 'Awesome Course', 10003);	

insert into student_course(student_id, course_id) values(20001, 10001);
insert into student_course(student_id, course_id) values(20002, 10001);
insert into student_course(student_id, course_id) values(20003, 10001);
insert into student_course(student_id, course_id) values(20001, 10003);

