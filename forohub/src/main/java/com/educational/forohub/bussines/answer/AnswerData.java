package com.educational.forohub.bussines.answer;

import com.educational.forohub.bussines.user.UserData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AnswerData {
  private String message;
  private String creationDate;
  private String autor;
  private String solution;

  public AnswerData(
          String message,
          String creationDate,
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

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
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
