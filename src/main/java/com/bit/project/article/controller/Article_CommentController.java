package com.bit.project.article.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.project.article.dto.request.Article_CommentRequest;
import com.bit.project.article.service.Article_CommentService;

@RequestMapping("/comments")
@RestController
public class Article_CommentController {
	private final Article_CommentService article_CommentService;

	public Article_CommentController(Article_CommentService article_CommentService) {
		this.article_CommentService = article_CommentService;
	}

	// 댓글 달기 구현
	// 댓글은 새로운 내용이므로 new
	@PostMapping("/new")
	public void postNewArticle_Comment(@RequestBody Article_CommentRequest article_CommentRequest) {
		article_CommentService.saveArticle_Comment(article_CommentRequest.toDto(null));
	}

	@PostMapping("/{commentId}/delete")
	public void deleteArticle_Comment(@PathVariable Long commentId, @PathVariable String userId, Long articleId) {
		article_CommentService.deleteArticle_Comment(commentId, userId);
	}
}
