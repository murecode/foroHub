package com.educational.forohub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String message;
  @Transient
  private Topic topic;
  @Column
  private LocalDateTime creationDate;
  @Transient
  private User autor;
  @Column
  private String solution;
}
