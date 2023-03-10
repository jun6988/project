package com.bit.project.article.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.ToString;

@Getter // 각 필드에 접근 가능
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass // AuditingFields 자체가 entity가 될 수 없고 무조건 상속을 받아야함으로 abstract
public abstract class AuditingFields {
	//Meta Data
	// setter x = 자동으로 JPA가 setting하도록 해야함 / 임의로 수정 불가 하도록 한다
	// 자동으로 setting 해주는 기술 = JPA Auditing
	// 생성 일시, 생성자 = 최초 insert
	// 수정 일시, 수정자 = 실시간 update
	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // web화면 보여줄 때, parameter 받을 때 pathing
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@CreatedDate @Column(updatable = false) // update 불가
	protected LocalDateTime createdAt; // 생성 일시
	
	@CreatedBy
	@Column(updatable = false, length = 100) // update 불가
	protected String createdBy; // 생성자 = 인증기능설정(JPA config)
	
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//	@LastModifiedDate @Column(nullable = false)
//	protected LocalDateTime modifiedAt; // 수정일시
//	
//	@LastModifiedBy
//	@Column(nullable = false, length = 100)
//	protected String modifiedBy; // 수정자
}
