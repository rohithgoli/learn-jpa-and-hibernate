package com.rrk.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rrk.springboot.learnjpaandhibernate.course.Course;

// A repository which talks to the course table
// Fire queries to DataBase using Spring JDBC

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
				INSERT INTO course(id, name, author)
				VALUES(?, ?, ?);
			""";
	
	private static String DELETE_QUERY = 
			"""
				DELETE FROM course
				WHERE id=?;
			""";
	
	private static String SELECT_QUERY = 
			"""
				SELECT * FROM course
				WHERE id = ?
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, 
				course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,
				id);
	}
	
	public Course findById(long id) {
		// ResultSet -->-- Bean using RowMapper
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class), id);
	}
}
