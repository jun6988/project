package com.bit.project.readingnote.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1493627425L;

    public static final QBook book = new QBook("book");

    public final StringPath book_author = createString("book_author");

    public final NumberPath<Integer> book_category_id = createNumber("book_category_id", Integer.class);

    public final StringPath book_img_url = createString("book_img_url");

    public final StringPath book_ISBN = createString("book_ISBN");

    public final StringPath book_publisher = createString("book_publisher");

    public final StringPath book_title = createString("book_title");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<ReadingNote, QReadingNote> readingNote = this.<ReadingNote, QReadingNote>createSet("readingNote", ReadingNote.class, QReadingNote.class, PathInits.DIRECT2);

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

