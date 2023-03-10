package com.bit.project.article.dto;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.bit.project.article.domain.Article;

public record ArticleWithCommentsDto(Long id, AccountDto accountDto,
		Set<Article_CommentDto> article_CommentDtos, String title, String content, String hashtag,
		LocalDateTime createdAt, String createdBy) {
	public static ArticleWithCommentsDto of(Long id, AccountDto accountDto,
			Set<Article_CommentDto> article_CommentDtos, String title, String content, String hashtag,
			LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
		return new ArticleWithCommentsDto(id, accountDto, article_CommentDtos, title, content, hashtag, createdAt,
				createdBy);
	}

	public static ArticleWithCommentsDto from(Article entity) {
		return new ArticleWithCommentsDto(entity.getId(), AccountDto.from(entity.getAccount()),
				entity.getArticle_Comments().stream().map(Article_CommentDto::from)
						.collect(Collectors.toCollection(LinkedHashSet::new)),
				entity.getTitle(), entity.getContent(), entity.getHashtag(), entity.getCreatedAt(),
				entity.getCreatedBy());
	}
}
