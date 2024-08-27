package org.zerock.projectmeongmung.entity;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Member;

@Entity
@Table(name = "StoryLikecount")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoryLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_likecountid", updatable = false)
    private Long story_likecountid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_seq", nullable = false)
    private MungStory storySeq;

    // storySeq 필드에 대한 Getter 메서드
    public MungStory getStorySeq() {
        return storySeq;
    }

}
