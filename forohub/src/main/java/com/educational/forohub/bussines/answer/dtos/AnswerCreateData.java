package com.educational.forohub.bussines.answer.dtos;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;

public class AnswerCreateData implements Serializable {
  private Long topic;
  private Long autor;
  @NotBlank
  private String message;
  @NotBlank
  private String solution;

  public AnswerCreateData(
          Long topic,
          Long autor,
          String message,
          String solution

  ) {
    this.topic = topic;
    this.autor = autor;
    this.message = message;
    this.solution = solution;
  }

  public Long getTopic() {
    return topic;
  }

  public void setTopic(Long topic) {
    this.topic = topic;
  }

  public Long getAutor() {
    return autor;
  }

  public void setAutor(Long autor) {
    this.autor = autor;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getSolution() {
    return solution;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }

}
