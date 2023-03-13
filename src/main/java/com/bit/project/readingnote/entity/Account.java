package com.bit.project.readingnote.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bit.project.article.domain.AuditingFields;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@Table(indexes = {
      @Index(columnList = "email", unique = true),
      @Index(columnList = "createdAt"),
      @Index(columnList = "createdBy")
})
@Entity
public class Account extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL autoincrement 방식
	private Long id;
	
    @Column(length = 50, unique = true)
    private String accountId;
	
	@Setter private String nickname;
	
	@Setter private String password;
	
	@Setter private String name;
	
	@Setter private String email;
	
	@Setter private String gender;
	
	@Setter private LocalDate birthday;
	
	@Setter private Integer age;
	
	@Setter private String joined_at;
	
	// 성준
	

	
//	private long reading_note_count;
	
//	private String profile_img_url;
	
//	private long male_persent;
	
//	private long female_persent;
	
//	private Integer twentys_percent;
	
//	private Integer thirtys_percent;
	
//	private Integer fortys_percent;
	
//	private Integer fifties_percent;
	
	
//	Account(1) : ReadingProgress(N) 설정
	@OneToMany(mappedBy = "account_id")
	public Set<ReadingProgress> readingProgress;
	
//	Account(1) : ReadingNote(N) 설정
	@OneToMany(mappedBy = "account_id")
	public Set<ReadingNote> readingNote;
	
//	Account(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy = "account_id")
	public Set<ReadingNoteComment> readingNoteComment;
	
////	Account(1) : ReadingNoteBookmark(N) 설정
//	@OneToMany(mappedBy = "account_id")
//	public Set<ReadingNoteBookmark> readingNoteBookmark;
	
	// 성준
	protected Account() {}
	
	private Account(String accountId, String password, String nickname, String email) {
		this.accountId = accountId;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}
	
	public static Account of(String accountId, String password, String nickname, String email) {
		return new Account(accountId, password, nickname, email);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(!(o instanceof Account that)) return false;
		return accountId != null && accountId.equals(that.getAccountId());
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountId);
	}
	
	
}
