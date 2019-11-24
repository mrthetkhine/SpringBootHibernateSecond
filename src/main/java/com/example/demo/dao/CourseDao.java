package com.example.demo.dao;
import java.util.List;

import com.example.demo.entity.*;
public interface CourseDao {
	List<Course> getAllCourse();
	List<Course> findByName(String name);
	
}
