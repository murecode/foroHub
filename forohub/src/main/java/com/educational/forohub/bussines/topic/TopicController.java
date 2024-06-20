package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.dtos.AnswerCreateData;
import com.educational.forohub.bussines.answer.dtos.AnswerReadData;
import com.educational.forohub.bussines.topic.dtos.TopicCreateData;
import com.educational.forohub.bussines.topic.dtos.TopicReadData;
import com.educational.forohub.bussines.topic.dtos.TopicUpdateData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {
  @Autowired
  private TopicService topicService;

  @GetMapping
  public ResponseEntity<Page<TopicReadData>> getAllTopics(
          @PageableDefault(
                  page = 0,
                  size = 10,
                  sort = {"creationDate"},
                  direction = Sort.Direction.ASC)
          Pageable pageable
  ) {
    Page<TopicReadData> topics = topicService.findAllTopics(pageable);
    return ResponseEntity.ok(topics);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TopicReadData> getTopic(
          @PathVariable("id") long topicId) {
    return topicService.findTopicById(topicId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/status={status}")
  public ResponseEntity<Page<TopicReadData>> getTopicsByStatus(
          @PageableDefault(page = 0, size = 5)
          @PathVariable TopicStatus status, Pageable pageable
  ) {
    Page<TopicReadData> topics = topicService.findAllTopicsByStatus(status, pageable);
    return ResponseEntity.ok(topics);
  }

  @PostMapping
  public ResponseEntity<TopicReadData> createTopic(
          @RequestBody @Valid TopicCreateData topicBody) {
    TopicReadData topicReadData = topicService.createTopic(topicBody);
    return new ResponseEntity<>(topicReadData, HttpStatus.CREATED);
  }

  @PostMapping("/add")
  public ResponseEntity<AnswerReadData> addAnswerToTopic(
          @RequestBody @Valid AnswerCreateData answerBody) {
    AnswerReadData answerReadData = topicService.addAnswerToTopic(answerBody);
    return new ResponseEntity<>(answerReadData, HttpStatus.CREATED);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TopicUpdateData> updateTopic(
          @PathVariable("id") long topicId,
          @RequestBody @Valid TopicUpdateData topicData) {
    topicService.updateTopic(topicId, topicData);
    return new ResponseEntity<>(topicData, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTopic(
          @PathVariable("id") long topicId) {
    topicService.deleteTopicById(topicId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
