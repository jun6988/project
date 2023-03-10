package com.bit.project.article.dto.response;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.bit.project.article.dto.ArticleWithCommentsDto;

public record ArticleWithCommentsResponse(Long id, String title, String content, String hashtag,
		LocalDateTime createdAt, String email, String nickname, String accountId,
		Set<Article_CommentResponse> article_CommentsResponse) {
	public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag,
			LocalDateTime createdAt, String email, String nickname, String accountId,
			Set<Article_CommentResponse> article_CommentResponses) {
		return new ArticleWithCommentsResponse(id, title, content, hashtag, createdAt, email, nickname, accountId,
				article_CommentResponses);
	}

	public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
		String nickname = dto.accountDto().nickname();
		if (nickname == null || nickname.isBlank()) {
			nickname = dto.accountDto().accountId();
		}
		return new ArticleWithCommentsResponse(dto.id(), dto.title(), dto.content(), dto.hashtag(), dto.createdAt(),
				dto.accountDto().email(), nickname, dto.accountDto().accountId(),
				dto.article_CommentDtos().stream().map(Article_CommentResponse::from)
						.collect(Collectors.toCollection(LinkedHashSet::new)));
	}
}
