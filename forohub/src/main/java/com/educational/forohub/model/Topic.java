package com.educational.forohub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
public class Topic {
  private Long id;
  private String title;
  private String message;
  private LocalDateTime creationDate;
  private Status status;
  private User autor;
  private Course course;
  private Answer answer;

}
