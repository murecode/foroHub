package com.educational.forohub.bussines.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {
  @Autowired
  private TopicService topicService;

  @GetMapping
  public ResponseEntity<Page<TopicData>> getAllTopics(
          @PageableDefault(
                  page = 0,
                  size = 10,
                  sort = {"creationDate"},
                  direction = Sort.Direction.ASC)
          Pageable pageable
  ) {
    Page<TopicData> topics = topicService.findAllTopics(pageable);
    return ResponseEntity.ok(topics);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TopicData> getTopic(@PathVariable("id") long topicid) {
    return topicService.findTopicById(topicid)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

  }

}
