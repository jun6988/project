package com.bit.project.readingnote.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.project.readingnote.entity.ReadingNote;
import com.bit.project.readingnote.repository.ReadingNoteRepository;

@Service
public class ReadingNoteService {

	@Autowired
	private ReadingNoteRepository readingNoteRepository;
	
	// 리스트 처리
	public List<ReadingNote> getReadingNoteList() {
		
		return readingNoteRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingNote> getReadingNoteListById(Integer id) {
		
		return readingNoteRepository.findById(id);
	}
	
	// 작성 처리
	public ReadingNote registReadingNote(ReadingNote readingNote) {
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		readingNote.setReading_note_regdate(nowDateTime.format(formatter));
		
		return readingNoteRepository.save(readingNote);
	}
	
	// 수정 처리
	public ReadingNote updateReadingNote(ReadingNote readingNote) {
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		readingNote.setReading_note_regdate(nowDateTime.format(formatter));
		
		return readingNoteRepository.saveAndFlush(readingNote);
	}
	
	// 삭제 처리
	public void removeReadingNote(Integer id) {
		
		readingNoteRepository.deleteById(id);
	}
	
//	// 시간 처리
//	public void nowTime(ReadingNote readingNote) {
//		
//		readingNote.setReading_note_regdate(LocalDate.now());
//	}
	
}
