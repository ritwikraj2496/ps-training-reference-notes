package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
//	
//	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Course", "this course contains basics of Java"));
//		list.add(new Course(146, "Hibernate Course", "this course will teach you complete hibernate"));
//	}

	@Override
	public List<Course> getCourses() {
		//return list;
		return courseDao.findAll();
	}

	//@SuppressWarnings("deprecation")
	@Override
	public Course getCourses(long courseId) {
//		Course c = null;
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//			c = course;
//			break;
//			}
//		}
//		return c;
		return courseDao.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list = this.list
//				.stream()
//				.filter(e->e.getId()!=courseId)
//				.collect(Collectors.toList());
		courseDao.deleteById(courseId);
	}

}
