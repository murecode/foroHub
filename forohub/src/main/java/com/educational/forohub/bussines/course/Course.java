package com.educational.forohub.bussines.course;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private CourseCategory courseCategory;
}
