package org.zerock.projectmeongmung.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "game_points")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GamePoints {

    @EmbeddedId
    private GamePointsId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @Column(name = "point", nullable = false)
    private int point;

    @Column(name = "time_played", nullable = false)
    private Timestamp timePlayed;

    @Column(name = "rest_count", nullable = false)
    private int restCount;

    @Builder
    public GamePoints(User user, GameType gameType, int point, Timestamp timePlayed, int restCount) {
        this.id = new GamePointsId(user.getId(), gameType);
        this.user = user;
        this.point = point;
        this.timePlayed = timePlayed;
        this.restCount = restCount;
    }

    public enum GameType {
        RSP, TIK, ROULETTE
    }
}
