package com.educational.forohub.bussines.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepo;

  public List<Topic> findAllTopics() {
    List<Topic> topics = topicRepo.findAll();
    return topics;
  }



}
