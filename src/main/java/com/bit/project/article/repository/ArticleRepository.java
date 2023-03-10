package com.bit.project.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bit.project.article.domain.Article;
import com.bit.project.article.repository.querydsl.ArticleRepositoryCustom;
import com.bit.project.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;

@RepositoryRestResource // DataRestRepository라는 것을 명시.
public interface ArticleRepository
		extends JpaRepository<Article, Long>, ArticleRepositoryCustom, QuerydslPredicateExecutor<Article>, QuerydslBinderCustomizer<QArticle> {
	// 검색 기능
	Page<Article> findByTitleContaining(String title, Pageable pageable);

	Page<Article> findByContentContaining(String content, Pageable pageable);

	Page<Article> findByAccount_AccountIdContaining(String accountId, Pageable pageable);

	Page<Article> findByAccount_NicknameContaining(String nickname, Pageable pageable);

	Page<Article> findByHashtag(String hashtag, Pageable pageable);

	// 게시글에서 삭제 부분 article id = user id 같을 때만 보이도록
	void deleteByIdAndAccount_AccountId(Long articleId, String accountid);

	@Override
	default void customize(QuerydslBindings bindings, QArticle root) {
		// 선택적으로 검색할 수 있는 기능을 false -> true
		bindings.excludeUnlistedProperties(true);
		// Articles에서 원하는 검색기능만 사용하기 위해 설정 후 밑에 root로 설정해줌
		bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy);
		// 대소문자 구분 안하는 검색기능
		bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
		bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
		bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
		bindings.bind(root.createdAt).first(DateTimeExpression::eq);
		bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
	}

	@Modifying
	@Query("UPDATE Article a SET a.hit = a.hit + 1 WHERE a.id = :id")
	void updateHit(@Param("id") Long id);
}