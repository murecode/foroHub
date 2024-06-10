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
    topic.setTitle("Duda Curso");
    topic.setMessage("Tengo una duda respecto al curso");
    topic.setCreationDate(LocalDate.now());
    topic.setStatus(Status.UNANSWERED);
    topic.setAutor(user);
    topic.setCourse(course);

    topicRepo.save(topic);

  }

}