package com.educational.forohub.bussines.answer.dtos;

import jakarta.validation.constraints.NotBlank;

public class AnswerUpdateData {
  @NotBlank
  private String message;
  @NotBlank
  private String solution;

  public AnswerUpdateData(
          String message,
          String solution)
  {
    this.message = message;
    this.solution = solution;
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
