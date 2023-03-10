package com.bit.project.article.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bit.project.readingnote.entity.Account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(indexes = { @Index(columnList = "content"), @Index(columnList = "createdAt"), @Index(columnList = "createdBy") })
//@EntityListeners(AuditingEntityListener.class) - JpaRepository에서 불러올 수 있다.
@Entity
public class Article_Comment extends AuditingFields {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// @ManyToOne = 연관관계 Mapping
	@Setter
	@ManyToOne(optional = false)
	private Article article; // 게시글 (ID)
	@Setter
	@ManyToOne(optional = false)
	@JoinColumn(name = "accountId")
	private Account account; // 유저 정보 (ID)
	@Setter
	@Column(nullable = false, length = 500)
	private String content; // 본문

	protected Article_Comment() {
	}

	private Article_Comment(Article article, Account account, String content) {
		this.article = article;
		this.account = account;
		this.content = content;
	}

	public static Article_Comment of(Article article, Account account, String content) {
		return new Article_Comment(article, account, content);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Article_Comment that))
			return false;
		return id != null && id.equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}



















