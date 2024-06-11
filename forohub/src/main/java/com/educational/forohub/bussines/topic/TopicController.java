package com.educational.forohub.bussines.topic;

import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping("")
  public ResponseEntity<List<TopicData>> getAllTopics() {
    List<TopicData> topics = topicService.findAllTopics();
    return ResponseEntity.ok(topics);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TopicData> getTopic(@PathVariable("id") long topicid) {
    return topicService.findTopicById(topicid)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

  }

}
