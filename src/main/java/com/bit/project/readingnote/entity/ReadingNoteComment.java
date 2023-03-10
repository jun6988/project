package com.bit.project.readingnote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ReadingNoteComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String content;
	
	private Integer reading_note_comment_like;
	
	private String reading_note_comment_regdate;
	
//	Account(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "account_id")
	private Integer account_id;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "reading_note_id")
	private Integer reading_note_id;
	
}
