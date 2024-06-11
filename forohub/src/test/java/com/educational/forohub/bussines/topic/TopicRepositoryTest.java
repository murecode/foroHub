package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.course.Course;
import com.educational.forohub.bussines.user.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class TopicRepositoryTest {
  @Autowired
  private TopicRepository topicRepo;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testCreateTopic() {
    User user = entityManager.find(User.class, 1);
    Course course = entityManager.find(Course.class, 1);

    Topic topic = new Topic();
    topic.setAutor(user);
    topic.setCourse(course);
    topic.setStatus(Status.UNANSWERED);
    topic.setCreationDate(LocalDate.now());
    topic.setTitle("");
    topic.setMessage("");

    assertTrue(topic.getTitle() == "");
    assertTrue(topic.getMessage() == "");

//    topicRepo.save(topic);

  }

  @Test
  void testUpdateTopic() {

  }

  @Test
  void testDeleteTopic() {
    Topic topic = entityManager.find(Topic.class, 5);

    topicRepo.deleteById(topic.getId());

    assertTrue(topic.getId() == 5);
  }



}