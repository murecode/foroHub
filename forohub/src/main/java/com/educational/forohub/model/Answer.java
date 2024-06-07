package com.educational.forohub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class Answer {
  private Long id;
  private String message;
  private Topic topic;
  private LocalDateTime creationDate;
  private User autor;
  private String solution;
}
