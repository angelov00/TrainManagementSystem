package com.example.trainmanagementsystem.model.entity;

import com.example.trainmanagementsystem.model.enumerations.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToMany
    private Set<Ticket> boughtTickets;
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
        this.boughtTickets = new LinkedHashSet<>();
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }


}
