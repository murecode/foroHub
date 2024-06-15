package com.educational.forohub.bussines.topic.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TopicCreateData {
  private Long autor;
  private Long course;
  @NotBlank
  private String title;
  @NotBlank
  private String message;

  public TopicCreateData(
          Long autor,
          Long course,
          String title,
          String message
  ) {
    this.autor = autor;
    this.course = course;
    this.title = title;
    this.message = message;
  }

  public Long getAutorId() {
    return autor;
  }

  public void setAutorId(Long autor) {
    this.autor = autor;
  }

  public Long getCourseId() {
    return course;
  }

  public void setCourseId(Long course) {
    this.course = course;
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
}
