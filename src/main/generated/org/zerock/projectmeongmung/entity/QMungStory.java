package org.zerock.projectmeongmung.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMungStory is a Querydsl query type for MungStory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMungStory extends EntityPathBase<MungStory> {

    private static final long serialVersionUID = 1463210251L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMungStory mungStory = new QMungStory("mungStory");

    public final SetPath<StoryLike, QStoryLike> likes = this.<StoryLike, QStoryLike>createSet("likes", StoryLike.class, QStoryLike.class, PathInits.DIRECT2);

    public final StringPath story_category = createString("story_category");

    public final StringPath story_content = createString("story_content");

    public final DateTimePath<java.util.Date> story_deletedate = createDateTime("story_deletedate", java.util.Date.class);

    public final NumberPath<Integer> story_likecount = createNumber("story_likecount", Integer.class);

    public final DateTimePath<java.util.Date> story_modddate = createDateTime("story_modddate", java.util.Date.class);

    public final StringPath story_picture = createString("story_picture");

    public final DateTimePath<java.util.Date> story_regdate = createDateTime("story_regdate", java.util.Date.class);

    public final NumberPath<Long> story_seq = createNumber("story_seq", Long.class);

    public final StringPath story_title = createString("story_title");

    public final StringPath story_viewcount = createString("story_viewcount");

    public final QUser user;

    public QMungStory(String variable) {
        this(MungStory.class, forVariable(variable), INITS);
    }

    public QMungStory(Path<? extends MungStory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMungStory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMungStory(PathMetadata metadata, PathInits inits) {
        this(MungStory.class, metadata, inits);
    }

    public QMungStory(Class<? extends MungStory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

