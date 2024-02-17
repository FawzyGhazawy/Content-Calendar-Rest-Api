package com.springBootProject.content.calendar.repository;

import com.springBootProject.content.calendar.model.Content;
import com.springBootProject.content.calendar.model.Status;
import com.springBootProject.content.calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }
    @PostConstruct
    public void init() {
        Content content = new Content(1,
                "My first Project",
                "I'm learning SpringBoot",
                Status.IN_PROGRESS,
                Type.COURSE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(content);
    }
}
