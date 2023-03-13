package com.bit.project.article.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.project.article.dto.request.Article_CommentRequest;
import com.bit.project.article.dto.security.BoardPrincipal;
import com.bit.project.article.service.Article_CommentService;

@RequestMapping("/comments")
@RestController
public class Article_CommentController {
	private final Article_CommentService article_CommentService;

	public Article_CommentController(Article_CommentService article_CommentService) {
		this.article_CommentService = article_CommentService;
	}

    @PostMapping ("/new")
    public void postNewArticle_Comment(
            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
            Article_CommentRequest article_CommentRequest
    ) {
        article_CommentService.saveArticle_Comment(article_CommentRequest.toDto(boardPrincipal.toDto())); 
    }

    @PostMapping ("/{commentId}/delete")
    public void deleteArticle_Comment(
            @PathVariable Long commentId,
            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
            Long articleId
    ) {
        article_CommentService.deleteArticle_Comment(commentId, boardPrincipal.getUsername());

    }

}