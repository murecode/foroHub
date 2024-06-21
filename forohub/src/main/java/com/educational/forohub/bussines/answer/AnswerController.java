package com.educational.forohub.bussines.answer;

import com.educational.forohub.bussines.answer.dtos.AnswerUpdateData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {
  @Autowired
  private AnswerService answerService;

  @PutMapping("/{id}")
  public ResponseEntity<AnswerUpdateData> updateAnswer(
          @PathVariable long id,
          @RequestBody @Valid AnswerUpdateData answerData
  ) {
    answerService.updateAnswer(id, answerData);
    return new ResponseEntity<>(answerData, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleleAnswer(@PathVariable long id) {
    answerService.deleteAnswer(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
