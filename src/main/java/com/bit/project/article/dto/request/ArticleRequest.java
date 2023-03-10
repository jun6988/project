package com.bit.project.article.dto.request;

import com.bit.project.article.dto.ArticleDto;
import com.bit.project.article.dto.AccountDto;

public record ArticleRequest(String title, String content, String hashtag, Long hit) {
	public static ArticleRequest of(String title, String content, String hashtag, Long hit) {
		return new ArticleRequest(title, content, hashtag, hit);
	}

	public ArticleDto toDto(AccountDto accountDto) {
		return ArticleDto.of(accountDto, title, content, hashtag, hit);
	}
}
