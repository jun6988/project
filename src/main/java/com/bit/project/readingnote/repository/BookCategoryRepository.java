package com.bit.project.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.project.readingnote.entity.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

}
