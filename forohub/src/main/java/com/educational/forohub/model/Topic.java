package com.educational.forohub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "topics")
@Data
@NoArgsConstructor
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String title;
  @Column
  private String message;
  @Column @Transient
  private LocalDate creationDate;
  @Transient
  private Status status;
  @OneToOne
  @JoinColumn(name = "autor_id")
  private User autor;
  @OneToOne
  @JoinColumn(name = "course_id")
  private Course course;
  @OneToMany(mappedBy = "topic")
  private List<Answer> answers;

}

//Docs:

/* @Data: Genera automáticamente los métodos getter, setter, toString, equals,
   hashCode y un constructor para los campos finales y anotados con @NonNull. */

/* @NoArgsConstructor: Genera un constructor sin argumentos. */

/* @AllArgsConstructor: Genera un constructor con un argumento para cada campo en la clase. */
