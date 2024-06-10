package com.educational.forohub.bussines.answer;

import com.educational.forohub.bussines.topic.Topic;
import com.educational.forohub.bussines.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "answers")
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String message;
  @ManyToOne()
  @JoinColumn(name = "topic_id")
  @JsonIgnore
  private Topic topic;
  @Column
  private LocalDate creationDate;
  @ManyToOne
  @JoinColumn(name = "autor_id")
  private User autor;
  @Column
  private String solution;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Topic getTopic() {
    return topic;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public User getAutor() {
    return autor;
  }

  public void setAutor(User autor) {
    this.autor = autor;
  }

  public String getSolution() {
    return solution;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }

  @Override
  public String toString() {
    return "Answer{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", topic=" + topic +
            ", creationDate=" + creationDate +
            ", autor=" + autor +
            ", solution='" + solution + '\'' +
            '}';
  }

}
