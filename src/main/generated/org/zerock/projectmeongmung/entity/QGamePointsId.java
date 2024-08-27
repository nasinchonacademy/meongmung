package org.zerock.projectmeongmung.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGamePointsId is a Querydsl query type for GamePointsId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QGamePointsId extends BeanPath<GamePointsId> {

    private static final long serialVersionUID = -56771815L;

    public static final QGamePointsId gamePointsId = new QGamePointsId("gamePointsId");

    public final EnumPath<GamePoints.GameType> gameType = createEnum("gameType", GamePoints.GameType.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QGamePointsId(String variable) {
        super(GamePointsId.class, forVariable(variable));
    }

    public QGamePointsId(Path<? extends GamePointsId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGamePointsId(PathMetadata metadata) {
        super(GamePointsId.class, metadata);
    }

}

