package com.bit.project.readingnote.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.project.readingnote.entity.ReadingNoteComment;
import com.bit.project.readingnote.repository.ReadingNoteCommentRepository;

@Service
public class ReadingNoteCommentService {

	@Autowired
	ReadingNoteCommentRepository readingNoteCommentRepository;
	
	// 리스트 처리
	public List<ReadingNoteComment> getReadingNoteCommentList(){
		
		return readingNoteCommentRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingNoteComment> getReadingNoteCommentListById(Integer id) {
		
		return readingNoteCommentRepository.findById(id);
	}
	
	// 작성 치러
	public ReadingNoteComment registReadingNoteComment(ReadingNoteComment readingNoteComment) {
	
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		readingNoteComment.setReading_note_comment_regdate(nowDateTime.format(formatter));
		
		return readingNoteCommentRepository.save(readingNoteComment);
	}
	
	// 수정 처리
	public ReadingNoteComment updateReadingNoteComment(ReadingNoteComment readingNoteComment) {
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		readingNoteComment.setReading_note_comment_regdate(nowDateTime.format(formatter));
		
		return readingNoteCommentRepository.saveAndFlush(readingNoteComment);
	}
	
	// 삭제 처리
	public void removeReadingNoteComment(Integer id) {
		
		readingNoteCommentRepository.deleteById(id);
	}
	
}
