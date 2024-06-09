package com.educational.forohub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
  @ManyToOne()
  @JoinColumn(name = "topic_id")
  private Topic topic;
  @Column @Transient
  private LocalDate creationDate;
  @ManyToOne
  @JoinColumn(name = "autor_id")
  private User autor;
  @Column
  private String solution;
}
