package com.bit.project.readingnote.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReadingNoteComment is a Querydsl query type for ReadingNoteComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReadingNoteComment extends EntityPathBase<ReadingNoteComment> {

    private static final long serialVersionUID = -1229086439L;

    public static final QReadingNoteComment readingNoteComment = new QReadingNoteComment("readingNoteComment");

    public final NumberPath<Integer> account_id = createNumber("account_id", Integer.class);

    public final StringPath content = createString("content");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> reading_note_comment_like = createNumber("reading_note_comment_like", Integer.class);

    public final StringPath reading_note_comment_regdate = createString("reading_note_comment_regdate");

    public final NumberPath<Integer> reading_note_id = createNumber("reading_note_id", Integer.class);

    public QReadingNoteComment(String variable) {
        super(ReadingNoteComment.class, forVariable(variable));
    }

    public QReadingNoteComment(Path<? extends ReadingNoteComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReadingNoteComment(PathMetadata metadata) {
        super(ReadingNoteComment.class, metadata);
    }

}

