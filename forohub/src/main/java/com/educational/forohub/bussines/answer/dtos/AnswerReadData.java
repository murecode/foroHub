package com.educational.forohub.bussines.answer.dtos;

import java.io.Serializable;
import java.time.LocalDate;

public class AnswerReadData implements Serializable {
  private String message;
  private LocalDate creationDate;
  private String autor;
  private String solution;

  public AnswerReadData(
          String message,
          LocalDate creationDate,
          String autor,
          String solution
  ) {
    this.message = message;
    this.creationDate = creationDate;
    this.autor = autor;
    this.solution = solution;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getSolution() {
    return solution;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }
}
