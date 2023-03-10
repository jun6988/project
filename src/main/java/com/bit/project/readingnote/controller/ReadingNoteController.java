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

import com.bit.project.readingnote.entity.ReadingNote;
import com.bit.project.readingnote.service.ReadingNoteService;

@RestController
@RequestMapping("/readingnote")
public class ReadingNoteController {

	@Autowired
	private ReadingNoteService readingNoteService;
	
	@GetMapping("/list")
	public List<ReadingNote> getAll() {
		
		return readingNoteService.getReadingNoteList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<ReadingNote> getReadingNoteById(@PathVariable("id") Integer id) {
		
		return readingNoteService.getReadingNoteListById(id);
	}
	
	@PostMapping("/regist")
	public ReadingNote registReadingNote(@RequestBody ReadingNote readingNote) {
		
		return readingNoteService.registReadingNote(readingNote);
	}
	
	@PutMapping("/update/{id}")
	public void updateReadingNote(
			@PathVariable("id") Integer id,
			@RequestBody ReadingNote readingNote) {
		
		readingNoteService.updateReadingNote(readingNote);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeReadingNote(@PathVariable Integer id) {
		
		readingNoteService.removeReadingNote(id);
	}
	
//	@GetMapping("/time")
//	public void getTime(ReadingNote readingNote) {
//		
//		return readingNoteService.nowTime();
//	}
	
}
