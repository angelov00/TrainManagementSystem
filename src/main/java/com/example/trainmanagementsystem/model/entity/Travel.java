package com.example.trainmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "travels")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Route route;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @ElementCollection
    private Set<LocalDateTime> timetable;


}
