package com.bit.project.readingnote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.project.readingnote.entity.BookCategory;
import com.bit.project.readingnote.repository.BookCategoryRepository;

@Service
public class BookCategoryService {

	@Autowired
	private BookCategoryRepository bookCategoryRepository;
	
	// 리스트 처리
	public List<BookCategory> getBookCategoryList() {
		
		return bookCategoryRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<BookCategory> getBookCategoryListById(Integer id) {
		
		return bookCategoryRepository.findById(id);
	}
	
	// 작성 처리
	public BookCategory registBookCategory(BookCategory bookCategory) {
		
		return bookCategoryRepository.save(bookCategory);
	}
	
	// 수정 처리
	public BookCategory updateBookCategory(BookCategory bookCategory) {
		
		return bookCategoryRepository.saveAndFlush(bookCategory);
	}
	
	// 삭제 처리
	public void removeBookCategory(Integer id) {
		
		bookCategoryRepository.deleteById(id);
	}

}
