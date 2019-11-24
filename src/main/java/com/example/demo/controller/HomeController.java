package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String home(Model model)
	{
		System.out.println("Controller Home");
		List<Book> books = (List<Book>) this.bookDao.findBookByTitle("Java");
		System.out.println("Book size "+books.size());
		for(Book b : books)
		{
			System.out.println("Book "+b.getTitle());
		}
		Book java = this.bookDao.getBookByIdWithNameQuery(1L);
		System.out.println("Java "+java.getTitle());
		model.addAttribute("book", java);
		System.out.println("Java Detail "+java.getBookDetail().getContent());
		
		int result = this.bookDao.updateBookTilte(1L, "Java SE");
		System.out.println("Update result"+result);
		
		System.out.println("Get book count "+ this.bookDao.getBookCount());
		Book book = this.bookDao.getBookByIdWithNative(1L);
		System.out.println("Fetch bok with native "+book.getTitle());
		return "home";
	}
	
	@GetMapping("/course")
	public String course()
	{
		System.out.println("Controller course");
		List<Course> courses = this.courseDao.findByName("Java");
		System.out.println("course size "+courses.size());
		for(Course c : courses)
		{
			System.out.println("Course "+c.getName());
		}
		return "home";
	}
}
