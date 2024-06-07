package com.educational.forohub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "courseCategories")
public class CourseCategory {
  private Long id;
  private String name;
}
