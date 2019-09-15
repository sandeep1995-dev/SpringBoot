package com.book.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.book.model.Book;

public interface BookService {

	public String insertBook(Book book);
	public List<Book> getAllBooks();
	public String deleteBookById(Integer id);
	public boolean updateRecord(Book book);
	public Book findBookById(Integer id);
}
