package com.example.demo.dao;

import java.util.List;

import com.example.demo.dao.common.GenericDao;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;

public interface BookDao extends GenericDao<Book,Long>{
	public List getAllBook() ;
	
	List<Book> findBookByTitle(String title);
	Book getById(Long id);
	Book getBookByIdWithNative(Long id);
	Book getBookByIdWithNameQuery(Long id);
	int updateBookTilte(Long id, String title);
	int getBookCount();
	List<Book> findBookByDescription(String description);
	long getBookCountByCriteria();
	public List<BookDto> getAllTitle();
}
