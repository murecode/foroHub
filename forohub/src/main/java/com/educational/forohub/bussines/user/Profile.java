package com.educational.forohub.bussines.user;

import jakarta.persistence.*;

@Entity
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
}
