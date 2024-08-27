package org.zerock.projectmeongmung.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoryLike is a Querydsl query type for StoryLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoryLike extends EntityPathBase<StoryLike> {

    private static final long serialVersionUID = -1298071773L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoryLike storyLike = new QStoryLike("storyLike");

    public final NumberPath<Long> story_likecountid = createNumber("story_likecountid", Long.class);

    public final QMungStory storySeq;

    public final QUser user;

    public QStoryLike(String variable) {
        this(StoryLike.class, forVariable(variable), INITS);
    }

    public QStoryLike(Path<? extends StoryLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoryLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoryLike(PathMetadata metadata, PathInits inits) {
        this(StoryLike.class, metadata, inits);
    }

    public QStoryLike(Class<? extends StoryLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.storySeq = inits.isInitialized("storySeq") ? new QMungStory(forProperty("storySeq"), inits.get("storySeq")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

