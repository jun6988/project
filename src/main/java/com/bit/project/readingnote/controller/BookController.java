package com.bit.project.readingnote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.project.readingnote.entity.Book;
import com.bit.project.readingnote.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public List<Book> getAll() {
		
		return bookService.getBookList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<Book> getBookById(@PathVariable("id") Integer id) {
		
		return bookService.getBookListById(id);
	}
	
	@PostMapping("/regist")
	public Book registBook(@RequestBody Book book) {
		
		System.out.println(book);
		
		return bookService.registBook(book);
	}
	
	@PutMapping("/update/{id}")
	public void updateBook(
			@PathVariable("id") Integer id,
			@RequestBody Book book) {
		
		bookService.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeBook(@PathVariable Integer id) {
		
		bookService.removeBook(id);
	}
	
}
