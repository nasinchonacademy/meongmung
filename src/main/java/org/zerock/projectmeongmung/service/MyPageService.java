package org.zerock.projectmeongmung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.projectmeongmung.entity.MungStory;
import org.zerock.projectmeongmung.entity.StoryLike;
import org.zerock.projectmeongmung.entity.User;
import org.zerock.projectmeongmung.repository.MungStoryRepository;
import org.zerock.projectmeongmung.repository.StoryLikeRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.zerock.projectmeongmung.entity.QMungStory.mungStory;

@Service
public class MyPageService {

    @Autowired
    private StoryLikeRepository storyLikeRepository;
    @Autowired
    private MungStoryRepository mungStoryRepository;

    public List<MungStory> getLikedStories(User user) {
        List<StoryLike> storyLikes = storyLikeRepository.findByUser(user);
        return storyLikes.stream()
                .map(StoryLike::getStorySeq)
                .collect(Collectors.toList());
    }

    public List<MungStory>getWrittenStories(User user){
        return mungStoryRepository.findByUserId(user.getId());
    }

}
