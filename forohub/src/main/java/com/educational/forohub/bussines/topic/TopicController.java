package com.educational.forohub.bussines.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
  @Autowired
  private TopicService topicService;

  @GetMapping("")
  public List<Topic> getAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/id")
  public String getTopic() {
    return "topicos";
  }
}
