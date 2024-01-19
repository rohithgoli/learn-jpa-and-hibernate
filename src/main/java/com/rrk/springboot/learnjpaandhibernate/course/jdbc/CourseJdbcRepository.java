package com.rrk.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// A repository which talks to the course table
// Fire queries to DataBase using Spring JDBC

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
				INSERT INTO course(id, name, author)
				VALUES(1, 'Learn Java, Spring, Spring Boot', 'rrk');
			""";
	
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}
	
}
