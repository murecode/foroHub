package com.educational.forohub.bussines.answer;

import com.educational.forohub.bussines.answer.dtos.AnswerReadData;
import com.educational.forohub.bussines.answer.dtos.AnswerUpdateData;
import com.educational.forohub.infra.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
  @Autowired
  private AnswerRepository answerRepo;

  public AnswerUpdateData updateAnswer(long answerId, AnswerUpdateData answerData) {
    Answer answer = answerRepo.findById(answerId).get();

    if (answerData.getMessage() != null) {
      answer.setMessage(answerData.getMessage());
    }
    if (answerData.getSolution() != null) {
      answer.setSolution(answerData.getSolution());
    }

    answerRepo.save(answer);

    return new AnswerUpdateData(
            answerData.getMessage(),
            answerData.getSolution()
    );
  }

  public void deleteAnswer(long id) {
    Optional<Answer> answer = answerRepo.findById(id);
    if (answer.isPresent()) {
      answerRepo.deleteById(answer.get().getId());
    } else {
      throw new RuntimeException("La respuesta que intentas eliminar no existe");
    }


  }

}
