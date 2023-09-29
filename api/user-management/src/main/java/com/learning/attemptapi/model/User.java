package com.learning.attemptapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user-table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
