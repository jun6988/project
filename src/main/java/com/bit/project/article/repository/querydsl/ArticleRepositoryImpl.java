package com.bit.project.article.repository.querydsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.bit.project.article.domain.Article;
import com.bit.project.domain.QArticle;

public class ArticleRepositoryImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {

	public ArticleRepositoryImpl() {
		super(Article.class);
	}

	@Override
	public List<String> findAllDistinctHashtags() {
		QArticle article = QArticle.article;
		return from(article).distinct().select(article.hashtag).where(article.hashtag.isNotNull()).fetch();
	}
}
