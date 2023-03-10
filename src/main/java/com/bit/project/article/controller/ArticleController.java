package com.bit.project.article.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.project.article.domain.constant.SearchType;
import com.bit.project.article.dto.ArticleDto;
import com.bit.project.article.dto.request.ArticleRequest;
import com.bit.project.article.dto.response.ArticleResponse;
import com.bit.project.article.dto.response.ArticleWithCommentsResponse;
import com.bit.project.article.service.ArticleService;
import com.bit.project.article.service.PaginationService;

@RequestMapping("/articles") // 모든 view endpoint가 articles로 시작
@RestController
public class ArticleController {
	private final ArticleService articleService;
	private final PaginationService paginationService;

	public ArticleController(ArticleService articleService, PaginationService paginationService) {
		this.articleService = articleService;
		this.paginationService = paginationService;
	}

	// 게시글 리스트 페이지 불러오기
	@GetMapping
	public Page<ArticleResponse> articles(
			// 검색어를 입력하면 검색기능으로 넘어가게 설정
			@RequestParam(required = false) SearchType searchType, @RequestParam(required = false) String searchValue,
			// 게시판 정렬 기능
			@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
		// DTO를 가공한 map을 사용하여 ArticleResponse 게시글(댓글 필요 없음) 불러온다.
		Page<ArticleResponse> articles = articleService.searchArticles(searchType, searchValue, pageable)
				.map(ArticleResponse::from);
		return articles;
	}

	// 게시글 단건 조회
	@GetMapping("/{articleId}")
	public ArticleWithCommentsResponse article(@PathVariable Long articleId) {
		ArticleWithCommentsResponse article = ArticleWithCommentsResponse
				.from(articleService.getArticleWithComments(articleId));
		articleService.updateHit(articleId); // 조회수 업데이트
		return article;
	}

	@GetMapping("/search-hashtag")
	public Page<ArticleResponse> searchArticleHashtag(@RequestParam(required = false) String searchValue,
			@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<ArticleResponse> articles = articleService.searchArticlesViaHashtag(searchValue, pageable)
				.map(ArticleResponse::from);
		return articles;
	}

//	@PostMapping("/form")
//	public void postNewArticle(ArticleRequest articleRequest) {
//		articleService.saveArticle(articleRequest.toDto(null));
//	}
	@PostMapping("/form")
	public void postNewArticle(ArticleDto articleDto) {
	    articleService.saveArticle(articleDto);
	}


	@PostMapping("/{articleId}/form")
	public void updateArticle(@PathVariable Long articleId, ArticleRequest articleRequest) {
		articleService.updateArticle(articleId, articleRequest.toDto(null));
	}
	

	@PostMapping("/{articleId}/delete")
	public void deleteArticle(@PathVariable Long articleId, @PathVariable String accountId) {
		articleService.deleteArticle(articleId, accountId);
	}
	

}