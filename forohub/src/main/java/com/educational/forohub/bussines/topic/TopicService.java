package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.Answer;
import com.educational.forohub.bussines.answer.dtos.AnswerCreateData;
import com.educational.forohub.bussines.answer.dtos.AnswerReadData;
import com.educational.forohub.bussines.course.Course;
import com.educational.forohub.bussines.topic.dtos.TopicCreateData;
import com.educational.forohub.bussines.topic.dtos.TopicReadData;
import com.educational.forohub.bussines.topic.dtos.TopicUpdateData;
import com.educational.forohub.infra.repository.AnswerRepository;
import com.educational.forohub.infra.security.model.User;
import com.educational.forohub.infra.repository.CourseRepository;
import com.educational.forohub.infra.repository.TopicRepository;
import com.educational.forohub.infra.repository.UserRepository;
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
  private AnswerRepository answerRepo;
  @Autowired
  private CourseRepository courseRepo;

  public Page<TopicReadData> findAllTopics(Pageable pageable) {
    Page<Topic> topics = topicRepo.findAll(pageable);
    return topics.map(t -> new TopicReadData(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getAutor().getName(),
            t.getCreationDate(),
            t.getStatus().toString(),
            t.getCourse().getName(),
            t.getAnswers().stream().map(a -> new AnswerReadData(
                    a.getId(),
                    a.getMessage(),
                    a.getCreationDate(),
                    a.getAutor().getName(),
                    a.getSolution()
            )).collect(Collectors.toList())
    ));
  }

  public Page<TopicReadData> findAllTopicsByStatus(TopicStatus status, Pageable pageable) {
    Page<Topic> topics = topicRepo.findByTopicStatus(status, pageable);
    return topics.map(t -> new TopicReadData(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getAutor().getName(),
            t.getCreationDate(),
            t.getStatus().toString(),
            t.getCourse().getName(),
            t.getAnswers().stream().map(a -> new AnswerReadData(
                    a.getId(),
                    a.getMessage(),
                    a.getCreationDate(),
                    a.getAutor().getName(),
                    a.getSolution()
            )).collect(Collectors.toList())
    ));
  }

  public Optional<TopicReadData> findTopicById(long topicId) {
    return topicRepo.findById(topicId).map(t -> new TopicReadData(
            t.getId(),
            t.getTitle(),
            t.getMessage(),
            t.getAutor().getName(),
            t.getCreationDate(),
            t.getStatus().toString(),
            t.getCourse().getName(),
            t.getAnswers().stream().map(a -> new AnswerReadData(
                    a.getId(),
                    a.getMessage(),
                    a.getCreationDate(),
                    a.getAutor().getName(),
                    a.getSolution()
            )).collect(Collectors.toList())
    ));
  }

  public TopicReadData createTopic(TopicCreateData topicBody) {

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

    return new TopicReadData(
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

  public AnswerReadData addAnswerToTopic(AnswerCreateData answerBody) {

    Topic topic = topicRepo.getReferenceById(answerBody.getTopic());
    User autor = userRepo.getReferenceById(answerBody.getAutor());

    //Verificaciones

    Answer answer = new Answer();
    answer.setTopic(topic);
    answer.setAutor(autor);
    answer.setCreationDate(LocalDate.now());
    answer.setMessage(answerBody.getMessage());
    answer.setSolution(answerBody.getSolution());

    Answer a = answerRepo.save(answer);

    return new AnswerReadData(
            a.getId(),
            a.getMessage(),
            a.getCreationDate(),
            a.getAutor().getName(),
            a.getSolution()
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

    topicRepo.save(topic);

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
