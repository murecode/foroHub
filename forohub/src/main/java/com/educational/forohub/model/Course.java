package com.educational.forohub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
  private Long id;
  private String name;
  private CourseCategory courseCategory;
}
