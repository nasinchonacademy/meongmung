package org.zerock.projectmeongmung.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GamePointsId implements Serializable {

    private Long userId;
    private GamePoints.GameType gameType;
}

