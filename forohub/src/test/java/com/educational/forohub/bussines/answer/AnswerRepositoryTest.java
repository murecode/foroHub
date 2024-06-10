package com.educational.forohub.bussines.answer;

import com.educational.forohub.bussines.topic.Topic;
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
class AnswerRepositoryTest {
  @Autowired
  private AnswerRepository answerRepo;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testAddAnswerToTopic() {
    User user = entityManager.find(User.class, 2);
    Topic topic = entityManager.find(Topic.class, 1);

    Answer answer = new Answer();
    answer.setAutor(user);
    answer.setTopic(topic);
    answer.setCreationDate(LocalDate.now());
    answer.setMessage("Esta es mi respuesta");
    answer.setSolution("Tienes que crear un nuevo objeto");

    answerRepo.save(answer);

  }

}