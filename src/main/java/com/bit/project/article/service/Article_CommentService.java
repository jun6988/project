package com.bit.project.article.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.project.article.domain.Article;
import com.bit.project.article.domain.Article_Comment;
import com.bit.project.article.dto.Article_CommentDto;
import com.bit.project.article.repository.AccountRepository;
import com.bit.project.article.repository.ArticleRepository;
import com.bit.project.article.repository.Article_CommentRepository;
import com.bit.project.readingnote.entity.Account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class Article_CommentService {
	private final ArticleRepository articleRepository;
	private final Article_CommentRepository article_CommentRepository;
	private final AccountRepository accountRepository;

	@Transactional(readOnly = true)
	// 댓글 리스트 조회 (id를 통해)
	public List<Article_CommentDto> searchArticle_Comments(Long articleId) {
		return article_CommentRepository.findByArticle_Id(articleId).stream().map(Article_CommentDto::from).toList();
	}

	public void saveArticle_Comment(Article_CommentDto dto) {
		try {
			// 게시글 정보 가져온 것
			Article article = articleRepository.getReferenceById(dto.articleId());
			// 댓글 단 user 정보 가져온 것
			Account account = accountRepository.getReferenceById(dto.accountDto().accountId());
			article_CommentRepository.save(dto.toEntity(article, account));
		} catch (EntityNotFoundException e) {
			log.warn("댓글 저장 실패. 댓글 작성에 필요한 정보를 찾을 수 없습니다 - {}", e.getLocalizedMessage());
		}
	}

	public void updateArticle_Comment(Article_CommentDto dto) {
		try {
			Article_Comment articleComment = article_CommentRepository.getReferenceById(dto.id());
			if (dto.content() != null) {
				articleComment.setContent(dto.content());
			}
		} catch (EntityNotFoundException e) {
			log.warn("댓글 업데이트 실패. 댓글을 찾을 수 없습니다 - dto: {}", dto);
		}
	}

	public void deleteArticle_Comment(Long article_CommentId, String accountId) {
		article_CommentRepository.deleteByIdAndAccount_AccountId(article_CommentId, accountId);
	}
}
