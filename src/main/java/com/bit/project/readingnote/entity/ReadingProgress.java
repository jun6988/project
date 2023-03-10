package com.bit.project.readingnote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ReadingProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String reading_progress_title;
	
	private Integer reading_progress_goal;
	
	private Integer reading_progress_attainment;
	
	private Integer attainment_percent;

//	Account(1) : ReadingProgress(N) 설정
//	@ManyToOne
	@Column(name = "account_id")
	private Integer account_id;
	
}
