package com.bit.project.article.dto.response;

import java.time.LocalDateTime;

import com.bit.project.article.dto.ArticleDto;

public record ArticleResponse(Long id, String title, String content, String hashtag, Long hit, LocalDateTime createdAt,
		String email, String nickname) {
	public static ArticleResponse of(Long id, String title, String content, String hashtag, Long hit,
			LocalDateTime createdAt, String email, String nickname) {
		return new ArticleResponse(id, title, content, hashtag, hit, createdAt, email, nickname);
	}

	public static ArticleResponse from(ArticleDto dto) {
		// 작성자 보여주는 것 (nickname 없으면 id)
		String nickname = dto.accountDto().nickname();
		if (nickname == null || nickname.isBlank()) {
			nickname = dto.accountDto().accountId();
		}
		return new ArticleResponse(dto.id(), dto.title(), dto.content(), dto.hashtag(), dto.hit(), dto.createdAt(),
				dto.accountDto().email(), nickname);
	}
}
