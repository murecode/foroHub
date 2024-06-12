package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.AnswerData;
import com.educational.forohub.bussines.topic.dtos.TopicData;
import com.educational.forohub.bussines.topic.dtos.TopicUpdateData;
import com.educational.forohub.infra.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

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

  public Optional<TopicData> findTopicById(long topicId) {
    return topicRepo.findById(topicId).map(t -> new TopicData(
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

  public TopicUpdateData updateTopic(long topicId, TopicUpdateData topicData) {
    Topic topic = topicRepo.getReferenceById(topicId);

    if (topicData.getTitle() != null) {
      topic.setTitle(topicData.getTitle());
    }
    if (topicData.getMessage() != null) {
      topic.setMessage(topicData.getMessage());
    }
    if (topicData.getStatus() != null) {
      topic.setStatus(topicData.getStatus());
    }

    Topic updatedTopic = topicRepo.save(topic);

    return new TopicUpdateData(
            topicData.getTitle(),
            topicData.getMessage(),
            topicData.getStatus()
    );
  }

  public void deleteTopicById(long topicId) {
    Topic topic = topicRepo.getReferenceById(topicId);
    topicRepo.deleteById(topic.getId());
  }


}
