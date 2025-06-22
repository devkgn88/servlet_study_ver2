package com.gn.service;

import java.util.List;

import com.gn.model.vo.Book;

public interface BookService {
	int insert(Book book);
	
	List<Book> list();
}
