package com.bit.project.article.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle_Comment is a Querydsl query type for Article_Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle_Comment extends EntityPathBase<Article_Comment> {

    private static final long serialVersionUID = 1925416615L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle_Comment article_Comment = new QArticle_Comment("article_Comment");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final com.bit.project.readingnote.entity.QAccount account;

    public final QArticle article;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QArticle_Comment(String variable) {
        this(Article_Comment.class, forVariable(variable), INITS);
    }

    public QArticle_Comment(Path<? extends Article_Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticle_Comment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticle_Comment(PathMetadata metadata, PathInits inits) {
        this(Article_Comment.class, metadata, inits);
    }

    public QArticle_Comment(Class<? extends Article_Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new com.bit.project.readingnote.entity.QAccount(forProperty("account")) : null;
        this.article = inits.isInitialized("article") ? new QArticle(forProperty("article"), inits.get("article")) : null;
    }

}

