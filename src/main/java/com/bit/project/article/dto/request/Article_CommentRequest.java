package com.bit.project.article.dto.request;

import com.bit.project.article.dto.Article_CommentDto;
import com.bit.project.article.dto.AccountDto;

public record Article_CommentRequest(Long articleId, String content) {
	// 댓글 달 때 필요한 data
	public static Article_CommentRequest of(Long articleId, String content) {
		return new Article_CommentRequest(articleId, content);
	}

	// user account에서 정보 받아야함
	public Article_CommentDto toDto(AccountDto accountDto) {
		return Article_CommentDto.of(articleId, accountDto, content);
	}
}
