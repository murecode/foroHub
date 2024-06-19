package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.AnswerData;
import com.educational.forohub.bussines.course.Course;
import com.educational.forohub.bussines.topic.dtos.TopicCreateData;
import com.educational.forohub.bussines.topic.dtos.TopicData;
import com.educational.forohub.bussines.topic.dtos.TopicUpdateData;
import com.educational.forohub.infra.security.model.User;
import com.educational.forohub.infra.repository.CourseRepository;
import com.educational.forohub.infra.repository.TopicRepository;
import com.educational.forohub.infra.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepo;
  @Autowired
  private UserRepository userRepo;
  @Autowired
  private CourseRepository courseRepo;

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

  public TopicData createTopic(TopicCreateData topicBody) {

    if(topicBody.getAutorId() == null || topicBody.getCourseId() == null) {
      throw new IllegalArgumentException("Autor ID y Course ID no debe ser null");
    }

    User autor = userRepo.getReferenceById(topicBody.getAutorId());
    Course course = courseRepo.getReferenceById(topicBody.getAutorId());

    Topic topic = new Topic();
    topic.setAutor(autor);
    topic.setCourse(course);
    topic.setTitle(topicBody.getTitle());
    topic.setMessage(topicBody.getMessage());
    topic.setCreationDate(LocalDate.now());
    topic.setStatus(TopicStatus.UNSOLVED);

    Topic t = topicRepo.save(topic);

    return new TopicData(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getAutor().getName(),
            t.getCreationDate(),
            t.getStatus().toString(),
            t.getCourse().getName(),
            new ArrayList<>()
    );
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
    Optional<Topic> topic = topicRepo.findById(topicId);
    if (topic.isPresent()) {
      topicRepo.deleteById(topic.get().getId());
    } else {
      throw new RuntimeException("El tópico que intentas eliminar no existe");
    }
  }


}
