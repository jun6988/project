package com.bit.project.readingnote.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReadingNote is a Querydsl query type for ReadingNote
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReadingNote extends EntityPathBase<ReadingNote> {

    private static final long serialVersionUID = 421922406L;

    public static final QReadingNote readingNote = new QReadingNote("readingNote");

    public final NumberPath<Integer> account_id = createNumber("account_id", Integer.class);

    public final NumberPath<Integer> book_id = createNumber("book_id", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> reading_note_bookmark = createNumber("reading_note_bookmark", Integer.class);

    public final StringPath reading_note_content = createString("reading_note_content");

    public final StringPath reading_note_file_url = createString("reading_note_file_url");

    public final StringPath reading_note_hashtag = createString("reading_note_hashtag");

    public final NumberPath<Integer> reading_note_hit = createNumber("reading_note_hit", Integer.class);

    public final NumberPath<Integer> reading_note_like = createNumber("reading_note_like", Integer.class);

    public final NumberPath<Integer> reading_note_open = createNumber("reading_note_open", Integer.class);

    public final StringPath reading_note_regdate = createString("reading_note_regdate");

    public final StringPath reading_note_title = createString("reading_note_title");

    public final SetPath<ReadingNoteComment, QReadingNoteComment> readingNoteComment = this.<ReadingNoteComment, QReadingNoteComment>createSet("readingNoteComment", ReadingNoteComment.class, QReadingNoteComment.class, PathInits.DIRECT2);

    public QReadingNote(String variable) {
        super(ReadingNote.class, forVariable(variable));
    }

    public QReadingNote(Path<? extends ReadingNote> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReadingNote(PathMetadata metadata) {
        super(ReadingNote.class, metadata);
    }

}

