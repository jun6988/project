package com.bit.project.article.dto;

import java.time.LocalDateTime;

import com.bit.project.article.domain.Article;
import com.bit.project.readingnote.entity.Account;

public record ArticleDto(
		// entity의 모든 정보를 가지고 있다.
		Long id, AccountDto accountDto, String title, String content, String hashtag, Long hit,
		LocalDateTime createdAt, String createdBy) {
	public static ArticleDto of(AccountDto accountDto, String title, String content, String hashtag, Long hit) {
		return new ArticleDto(null, accountDto, title, content, hashtag, hit, null, null);
	}

	public static ArticleDto of(Long id, AccountDto accountDto, String title, String content, String hashtag,
			Long hit, LocalDateTime createdAt, String createdBy) {
		return new ArticleDto(id, accountDto, title, content, hashtag, hit, createdAt, createdBy);
	}

	// 자기 자신을 entity로 부터 반환한다.
	// entity를 입력하면 DTO로 변환해준다.
	// mapping 해서 return 해줌
	public static ArticleDto from(Article entity) {
		return new ArticleDto(entity.getId(), AccountDto.from(entity.getAccount()), entity.getTitle(),
				entity.getContent(), entity.getHashtag(), entity.getHit(), entity.getCreatedAt(), entity.getCreatedBy()
				);
	}

	// DTO로 부터 entity를 생성해주는 코드 (위 코드와 반대)
	public Article toEntity(Account account) {
		return Article.of(account, title, content, hashtag, hit);
	}
}