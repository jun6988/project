package com.bit.project.readingnote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.project.readingnote.entity.BookCategory;
import com.bit.project.readingnote.service.BookCategoryService;

@RestController
@RequestMapping("/bookcategory")
public class BookCategoryController {
	
	@Autowired
	private BookCategoryService bookCategoryService;
	
	@GetMapping("/list")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public List<BookCategory> getAll() {
		
		return bookCategoryService.getBookCategoryList();
	}
	
	@GetMapping("/list/{id}")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public Optional<BookCategory> getBookCategoryById(@PathVariable("id") Integer id) {
		
		return bookCategoryService.getBookCategoryListById(id);
	}
	
	@PostMapping("/regist")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public BookCategory registBookCategory(@RequestBody BookCategory bookCategory) {
		
		System.out.println(bookCategory);
		
		return bookCategoryService.registBookCategory(bookCategory);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public void updateBookCategory(
			@PathVariable("id") Integer id,
			@RequestBody BookCategory bookCategory) {
		
		bookCategoryService.updateBookCategory(bookCategory);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public void removeBookCategory(@PathVariable Integer id) {
		
		bookCategoryService.removeBookCategory(id);
	}
	
}
