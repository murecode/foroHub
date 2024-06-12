package com.educational.forohub.bussines.topic.dtos;

import com.educational.forohub.bussines.topic.TopicStatus;

public class TopicUpdateData {
  private String title;
  private String message;
  private TopicStatus topicStatus;

  public TopicUpdateData(String title, String message, TopicStatus topicStatus) {
    this.title = title;
    this.message = message;
    this.topicStatus = topicStatus;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public TopicStatus getStatus() {
    return topicStatus;
  }

  public void setStatus(TopicStatus topicStatus) {
    this.topicStatus = topicStatus;
  }
}
