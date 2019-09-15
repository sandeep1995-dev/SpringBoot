package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookEntity;
import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;
	
	@Override
public String insertBook(Book bookModel) {
		//convert model  to entity
		BookEntity entity=new BookEntity();
		BeanUtils.copyProperties(bookModel, entity);
		entity=bookRepo.save(entity);
		if(entity.getBookId()>0)
			return "Book Inserted Successfully";
		else
			return "Fail to Insert";
}
	@Override
	public List<Book> getAllBooks() {
		//use repo
	List<BookEntity>entities=bookRepo.findAll();
	//convert entities into model
	List<Book> booksList=new ArrayList<>();
		entities.forEach(e->{
			Book bookModel=new Book();
			BeanUtils.copyProperties(e, bookModel);
			booksList.add(bookModel);
		});
		return booksList;
	}
	
	@Override
	public Book findBookById(Integer id) {
		//use repo to get book record
		Optional<BookEntity> optional=bookRepo.findById(id);
		//check record is there or not
		Book bookModel =null;
		if(optional.isPresent()) {
		BookEntity entity=optional.get();
		//convert entity to model
		bookModel=new Book();
		BeanUtils.copyProperties(entity, bookModel);
		}
		return bookModel;
	}
	
	@Override
	public boolean updateRecord(Book bookModel) {
		BookEntity entity=new BookEntity();
		BeanUtils.copyProperties(bookModel, entity);
		entity=bookRepo.save(entity);
		return entity.getBookId()>0;
	}
	
	@Override
	public String deleteBookById(Integer id) {
		//use repo
		if(bookRepo.existsById(id)) {
		bookRepo.deleteById(id);
		return "Record deleted Successfully";
		}
		return "Record Not Found";
	}//delete
	
	
}//class
