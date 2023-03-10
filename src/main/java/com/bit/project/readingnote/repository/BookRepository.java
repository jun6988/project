package com.bit.project.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.project.readingnote.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
