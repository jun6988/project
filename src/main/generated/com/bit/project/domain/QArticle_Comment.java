package com.bit.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.processing.Generated;

import com.bit.project.article.domain.Article_Comment;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;


/**
 * QArticle_Comment is a Querydsl query type for Article_Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle_Comment extends EntityPathBase<Article_Comment> {

    private static final long serialVersionUID = -1067769557L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle_Comment article_Comment = new QArticle_Comment("article_Comment");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final QArticle article;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final QAccount account;

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
        this.article = inits.isInitialized("article") ? new QArticle(forProperty("article"), inits.get("article")) : null;
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account")) : null;
    }

}

