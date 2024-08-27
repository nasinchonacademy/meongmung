package org.zerock.projectmeongmung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.projectmeongmung.entity.GamePoints;
import org.zerock.projectmeongmung.entity.GamePointsId;

public interface GamePointsRepository extends JpaRepository<GamePoints, GamePointsId> {
}
