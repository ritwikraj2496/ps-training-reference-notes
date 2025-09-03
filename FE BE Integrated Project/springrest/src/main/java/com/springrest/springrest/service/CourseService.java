package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {

	public List<Course> getCourses(); //get all courses
	
	public Course getCourses(long courseId); //get a single course

	public Course addCourse(Course course); //adding a course

	public Course updateCourse(Course course); //updating a course

	public void deleteCourse(long courseId); //deleting a course
	
}

