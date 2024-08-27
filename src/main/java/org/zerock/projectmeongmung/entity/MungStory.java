package org.zerock.projectmeongmung.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.Set;

@Table(name = "meongstory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class MungStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_seq", updatable = false)
    private Long story_seq;

    @Column(name = "story_title",  nullable = false)
    private String story_title;

    @Column(name = "story_content",  nullable = false)
    private String story_content;

    @Column(name = "story_likecount", unique = true, nullable = false)
    private int story_likecount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "story_regdate", nullable = false)
    @CreatedDate
    private Date story_regdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "story_modddate")
    private Date story_modddate;

    @Column(name="story_picture")
    private String story_picture;

    @Column(name="story_viewcount", nullable = false)
    private String story_viewcount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "story_deletedate")
    private Date story_deletedate;

    @Column(name = "story_category", nullable = false)
    private String story_category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "storySeq")  // 여기서 mappedBy를 storySeq로 수정
    private Set<StoryLike> likes;

    @Builder
    public MungStory(String story_title, String story_content, int story_likecount, String story_picture, String story_viewcount, String story_category) {
        this.story_title = story_title;
        this.story_content = story_content;
        this.story_likecount = story_likecount;
        this.story_picture = story_picture;
        this.story_viewcount = story_viewcount;
        this.story_category = story_category;
    }



}
