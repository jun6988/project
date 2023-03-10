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

import com.bit.project.readingnote.entity.ReadingNoteComment;
import com.bit.project.readingnote.service.ReadingNoteCommentService;

@RestController
@RequestMapping("/readingnotecomment")
public class ReadingNoteCommentController {

	@Autowired
	ReadingNoteCommentService readingNoteCommentService;
	
	@GetMapping("/list")
	public List<ReadingNoteComment> getAll(){
		
		return readingNoteCommentService.getReadingNoteCommentList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<ReadingNoteComment> getReadingNoteCommentById(@PathVariable("id") Integer id) {
		
		return readingNoteCommentService.getReadingNoteCommentListById(id);
	}
	
	@PostMapping("/regist")
	public ReadingNoteComment registReadingNoteComment(@RequestBody ReadingNoteComment readingNoteComment) {
		
		return readingNoteCommentService.registReadingNoteComment(readingNoteComment);
	}
	
	@PutMapping("/update/{id}")
	public void updateReadingNoteComment(
			@PathVariable("id") Integer id,
			@RequestBody ReadingNoteComment readingNoteComment) {
		
		readingNoteCommentService.updateReadingNoteComment(readingNoteComment);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeReadingNoteComment(@PathVariable Integer id) {
		
		readingNoteCommentService.removeReadingNoteComment(id);
	}
}
