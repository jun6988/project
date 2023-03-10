package com.bit.project.readingnote.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = -448469003L;

    public static final QAccount account = new QAccount("account");

    public final com.bit.project.article.domain.QAuditingFields _super = new com.bit.project.article.domain.QAuditingFields(this);

    public final StringPath accountId = createString("accountId");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final SetPath<ReadingNote, QReadingNote> readingNote = this.<ReadingNote, QReadingNote>createSet("readingNote", ReadingNote.class, QReadingNote.class, PathInits.DIRECT2);

    public final SetPath<ReadingNoteComment, QReadingNoteComment> readingNoteComment = this.<ReadingNoteComment, QReadingNoteComment>createSet("readingNoteComment", ReadingNoteComment.class, QReadingNoteComment.class, PathInits.DIRECT2);

    public final SetPath<ReadingProgress, QReadingProgress> readingProgress = this.<ReadingProgress, QReadingProgress>createSet("readingProgress", ReadingProgress.class, QReadingProgress.class, PathInits.DIRECT2);

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

