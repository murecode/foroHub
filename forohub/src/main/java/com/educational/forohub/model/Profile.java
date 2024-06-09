package com.educational.forohub.model;

import jakarta.persistence.*;

@Entity
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
}
