package com.book.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.book.model.Book;
import com.book.service.BookService;

@Controller
public class BookController2 {
	@Autowired
	private BookService service;

	@GetMapping(value = "/form")
	public String bookHomePage(Model model) {
		model.addAttribute("books", new Book());
		return "display_books";
	}

	@PostMapping("/bookReg")
	public String bookRegistration(@ModelAttribute("books") Book book, RedirectAttributes attribute) {
		// use service to insert the book
		String msg = service.insertBook(book);
		// add success msg to add attribute
		attribute.addFlashAttribute("msg", msg);
		// get all book dtls
		List<Book> booksList = service.getAllBooks();
		attribute.addFlashAttribute("booksList", booksList);
		return "redirect:/form";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteById(@RequestParam("id") Integer id, Model model, @ModelAttribute("books") Book book) {
		String msg = service.deleteBookById(id);
		// get all book dtls
		List<Book> booksList = service.getAllBooks();
		model.addAttribute("msg", msg);
		model.addAttribute("booksList", booksList);
		return "display_books";
	}

	@RequestMapping(value="/editBook",method=RequestMethod.GET)
	public String  updateById(@RequestParam("id") Integer id,Model model) {
		//copy one book value into
		 Book book=service.findBookById(id);
		model.addAttribute("books", book);
		List<Book> booksList = service.getAllBooks();
		model.addAttribute("booksList", booksList);
	  return"display_books";
	  }

	/*
	 * @RequestMapping(value="/update",method=RequestMethod.POST) public String
	 * updatedById(Model model, @ModelAttribute("books") Book book) {
	 * Collection<Book> collection=service.updatedRecord(book); //copy one book
	 * value into bookModel model.addAttribute("bookMap",collection);
	 * return"display_books"; }
	 */
}
