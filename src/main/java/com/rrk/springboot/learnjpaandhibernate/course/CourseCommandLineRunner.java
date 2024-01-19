package com.rrk.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rrk.springboot.learnjpaandhibernate.course.Course;
import com.rrk.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Learn Java, SpringBoot", "rrk"));
		repository.insert(new Course(2, "Learn Python", "rrk"));
		repository.insert(new Course(3, "Learn FullStack Development", "rrk"));
	
		repository.deleteById(1);
		
		System.out.println(repository.findById(3));
		System.out.println(repository.findById(2));
	}

}
