package org.zerock.projectmeongmung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.projectmeongmung.entity.MungStory;
import org.zerock.projectmeongmung.entity.User;

import java.util.List;

@Repository
public interface MungStoryRepository extends JpaRepository<MungStory, Long> {
    List<MungStory> findByUserId(Long userId);
}
