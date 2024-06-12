package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.AnswerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepo;

  public Page<TopicData> findAllTopics(Pageable pageable) {
    Page<Topic> topics = topicRepo.findAll(pageable);
    return topics.map(t -> new TopicData(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getAutor().getName(),
            t.getCreationDate(),
            t.getStatus().toString(),
            t.getCourse().getName(),
            t.getAnswers().stream().map(a -> new AnswerData(
                    a.getMessage(),
                    a.getCreationDate(),
                    a.getAutor().getName(),
                    a.getSolution()
            )).collect(Collectors.toList())
    ));
  }

  public Optional<TopicData> findTopicById(long topicid) {
    return topicRepo.findById(topicid).map(t -> new TopicData(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getAutor().getName(),
            t.getCreationDate(),
            t.getStatus().toString(),
            t.getCourse().getName(),
            t.getAnswers().stream().map(a -> new AnswerData(
                    a.getMessage(),
                    a.getCreationDate(),
                    a.getAutor().getName(),
                    a.getSolution()
            )).collect(Collectors.toList())
    ));
  }



}
