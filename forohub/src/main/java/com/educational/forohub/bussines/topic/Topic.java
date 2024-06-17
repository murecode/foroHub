package com.educational.forohub.bussines.topic;

import com.educational.forohub.bussines.answer.Answer;
import com.educational.forohub.bussines.course.Course;
import com.educational.forohub.infra.security.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String title;
  @Column
  private String message;
  @Column
  private LocalDate creationDate;
  @Column
  @Enumerated(EnumType.STRING)
  private TopicStatus topicStatus;
  @ManyToOne
  @JoinColumn(name = "autor_id")
  private User autor;
  @OneToOne
  @JoinColumn(name = "course_id")
  private Course course;
  @OneToMany(mappedBy = "topic", cascade = CascadeType.REMOVE)
  private List<Answer> answers;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public TopicStatus getStatus() {
    return topicStatus;
  }

  public void setStatus(TopicStatus topicStatus) {
    this.topicStatus = topicStatus;
  }

  public User getAutor() {
    return autor;
  }

  public void setAutor(User autor) {
    this.autor = autor;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  @Override
  public String toString() {
    return "Topic{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", message='" + message + '\'' +
            ", creationDate=" + creationDate +
            ", status=" + topicStatus +
            ", autor=" + autor +
            ", course=" + course +
            ", answers=" + answers +
            '}';
  }
}

//Docs:

/* @Data: Genera automáticamente los métodos getter, setter, toString, equals,
   hashCode y un constructor para los campos finales y anotados con @NonNull. */

/* @NoArgsConstructor: Genera un constructor sin argumentos. */

/* @AllArgsConstructor: Genera un constructor con un argumento para cada campo en la clase. */
