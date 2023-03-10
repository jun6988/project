package com.bit.project.article.dto.response;

import java.time.LocalDateTime;

import com.bit.project.article.dto.Article_CommentDto;

public record Article_CommentResponse(Long id, String content, LocalDateTime createdAt, String email, String nickname, String userId) {
	public static Article_CommentResponse of(Long id, String content, LocalDateTime createdAt, String email,
			String nickname, String accountId) {
		return new Article_CommentResponse(id, content, createdAt, email, nickname, accountId);
	}

	// nickname 가공
	// user account에서 꺼내는 장면
	public static Article_CommentResponse from(Article_CommentDto dto) { // Article_CommentDto를 받아서
		String nickname = dto.accountDto().nickname(); // 닉네임을 닉네임으로부터 불러오고
		if (nickname == null || nickname.isBlank()) { // 만약 없으면 (null field)
			nickname = dto.accountDto().accountId(); // userId를 불러와서 userId나 닉네임(우선순위 1)을 불러와서 setting되서 출력되도록 형성
		}
		return new Article_CommentResponse(dto.id(), dto.content(), dto.createdAt(), dto.accountDto().email(),
				nickname, // 닉네임 출력 보장
				dto.accountDto().accountId());
	}
}
