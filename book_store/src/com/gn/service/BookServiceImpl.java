package com.gn.service;

import java.util.List;

import com.gn.dao.BookDAO;
import com.gn.model.vo.Book;

public class BookServiceImpl implements BookService{
	
	private BookDAO bookDAO = new BookDAO();
	
	@Override
	public List<Book> list(){
		List<Book> resultList = bookDAO.list();
		return resultList;
	}
	
	@Override
	public int insert(Book book) {
		int result = bookDAO.insert(book);
		return result;
	}
	

}
