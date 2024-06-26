package com.educational.forohub.infra.repository;

import com.educational.forohub.bussines.answer.Answer;
import com.educational.forohub.bussines.course.Course;
import com.educational.forohub.bussines.topic.TopicStatus;
import com.educational.forohub.bussines.topic.Topic;
import com.educational.forohub.infra.security.model.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class TopicRepositoryTest {
  @Autowired
  private TopicRepository topicRepo;
  @Autowired
  private AnswerRepository answerRepo;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testCreateTopic() {
    User user = entityManager.find(User.class, 1);
    Course course = entityManager.find(Course.class, 1);

    Topic topic = new Topic();
    topic.setAutor(user);
    topic.setCourse(course);
    topic.setStatus(TopicStatus.UNSOLVED);
    topic.setCreationDate(LocalDate.now());
    topic.setTitle("");
    topic.setMessage("");

    assertSame("", topic.getTitle());
    assertSame("", topic.getMessage());

//    topicRepo.save(topic);

  }

  @Test
  void testAddAnswerToTopic() {
    Topic topic = entityManager.find(Topic.class, 31);
    User autor = entityManager.find(User.class, 2);

    Answer answer = new Answer();
    answer.setTopic(topic);
    answer.setAutor(autor);
    answer.setSolution("Esta es la solucion");
    answer.setMessage("Este es el mensaje de la solucion");
    answer.setCreationDate(LocalDate.now());

    answerRepo.save(answer);

  }


  @Test
  void testUpdateTopic() {

  }

  @Test
  void testDeleteTopic() {
    Topic topic = entityManager.find(Topic.class, 5);

    topicRepo.deleteById(topic.getId());

    Assertions.assertTrue(topic.getId() == 5);
  }



}