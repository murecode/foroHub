package com.educational.forohub.infra.repository;

import com.educational.forohub.bussines.answer.Answer;
import com.educational.forohub.bussines.topic.Topic;
import com.educational.forohub.infra.security.model.User;
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
class AnswerRepositoryTest {
  @Autowired
  private AnswerRepository answerRepo;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testAddAnswerToTopic() {
    var user = entityManager.find(User.class, 2);
    Topic topic = entityManager.find(Topic.class, 5);

    Answer answer = new Answer();
    answer.setAutor(user);
    answer.setTopic(topic);
    answer.setCreationDate(LocalDate.now());
    answer.setMessage("Respuesta Topico 5");
    answer.setSolution("Drop a la tabla en base de datos");

    answerRepo.save(answer);

  }

  //Editar respuesta
  //Eliminar respuesta

}