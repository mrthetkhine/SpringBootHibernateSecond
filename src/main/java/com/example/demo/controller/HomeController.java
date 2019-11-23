package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BookDaoImpl;
import com.example.demo.dao.CourseDao;

import java.util.*;
import com.example.demo.entity.*;
@Controller	
public class HomeController {
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/")
	public String home()
	{
		System.out.println("Controller Home");
		List<Book> books = (List<Book>) this.bookDao.findBookByTitle("Java");
		System.out.println("Book size "+books.size());
		for(Book b : books)
		{
			System.out.println("Book "+b.getTile());
		}
		return "home";
	}
	
	@GetMapping("/course")
	public String course()
	{
		System.out.println("Controller course");
		List<Course> courses = this.courseDao.getAllCourse();
		System.out.println("course size "+courses.size());
		for(Course c : courses)
		{
			System.out.println("Course "+c.getName());
		}
		return "home";
	}
}
