package com.bit.project.readingnote.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookCategory is a Querydsl query type for BookCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookCategory extends EntityPathBase<BookCategory> {

    private static final long serialVersionUID = -945528257L;

    public static final QBookCategory bookCategory = new QBookCategory("bookCategory");

    public final SetPath<Book, QBook> book = this.<Book, QBook>createSet("book", Book.class, QBook.class, PathInits.DIRECT2);

    public final StringPath book_category_name = createString("book_category_name");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QBookCategory(String variable) {
        super(BookCategory.class, forVariable(variable));
    }

    public QBookCategory(Path<? extends BookCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookCategory(PathMetadata metadata) {
        super(BookCategory.class, metadata);
    }

}

