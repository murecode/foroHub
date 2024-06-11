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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CourseCategory getCourseCategory() {
    return courseCategory;
  }

  public void setCourseCategory(CourseCategory courseCategory) {
    this.courseCategory = courseCategory;
  }

  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", courseCategory=" + courseCategory +
            '}';
  }

}
