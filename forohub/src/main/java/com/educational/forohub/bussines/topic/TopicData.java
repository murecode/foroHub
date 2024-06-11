package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.AnswerData;
import com.educational.forohub.bussines.course.Course;
import com.educational.forohub.bussines.user.UserData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class TopicData implements Serializable {
  private String id;
  private String title;
  private String message;
  private String creationDate;
  private String status;
  private String autor;
  private String course;
  private List<AnswerData> answers;

  public TopicData(
          String id,
          String title,
          String message,
          String autor,
          String creationDate,
          String status,
          String course,
          List<AnswerData> answers
  ) {
    this.id = id;
    this.title = title;
    this.message = message;
    this.autor = autor;
    this.creationDate = creationDate;
    this.status = status;
    this.course = course;
    this.answers = answers;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public List<AnswerData> getAnswers() {
    return answers;
  }

  public void setAnswers(List<AnswerData> answers) {
    this.answers = answers;
  }

}
