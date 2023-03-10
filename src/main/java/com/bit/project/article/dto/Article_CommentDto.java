package com.bit.project.article.dto;

import java.time.LocalDateTime;

import com.bit.project.article.domain.Article;
import com.bit.project.article.domain.Article_Comment;
import com.bit.project.readingnote.entity.Account;

public record Article_CommentDto(Long id, Long articleId, AccountDto accountDto, String content,
		LocalDateTime createdAt, String createdBy) {
	// user 정보 없을 때 넣을 수 없는 데이터 값 = null (articlecommentrequest)
	public static Article_CommentDto of(Long articleId, AccountDto accountDto, String content) {
		return new Article_CommentDto(null, articleId, accountDto, content, null, null);
	}

	public static Article_CommentDto of(
			Long id, 
			Long articleId,
			AccountDto accountDto, 
			String content,
			LocalDateTime createdAt, 
			String createdBy 
			) {
		return new Article_CommentDto(id, articleId, accountDto, content, createdAt, createdBy);
	}

	public static Article_CommentDto from(Article_Comment entity
			) {
		return new Article_CommentDto(
				entity.getId(), 
				entity.getArticle().getId(),
				AccountDto.from(entity.getAccount()), 
				entity.getContent(), 
				entity.getCreatedAt(),
				entity.getCreatedBy());
	}

	public Article_Comment toEntity(Article article, Account account) {
		return Article_Comment.of(article, account, content);
	}
}
