package com.bit.project.readingnote.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReadingProgress is a Querydsl query type for ReadingProgress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReadingProgress extends EntityPathBase<ReadingProgress> {

    private static final long serialVersionUID = -695288159L;

    public static final QReadingProgress readingProgress = new QReadingProgress("readingProgress");

    public final NumberPath<Integer> account_id = createNumber("account_id", Integer.class);

    public final NumberPath<Integer> attainment_percent = createNumber("attainment_percent", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> reading_progress_attainment = createNumber("reading_progress_attainment", Integer.class);

    public final NumberPath<Integer> reading_progress_goal = createNumber("reading_progress_goal", Integer.class);

    public final StringPath reading_progress_title = createString("reading_progress_title");

    public QReadingProgress(String variable) {
        super(ReadingProgress.class, forVariable(variable));
    }

    public QReadingProgress(Path<? extends ReadingProgress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReadingProgress(PathMetadata metadata) {
        super(ReadingProgress.class, metadata);
    }

}

