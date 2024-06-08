package com.example.trainmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    LocalDateTime boughtOn;
    @Column(nullable = false)
    private short seatNumber;
    @Column(nullable = false)
    private boolean paid;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    private User user;
    @ManyToOne
    private Travel travel;
    @ManyToOne
    private Station departureStation;
    @ManyToOne
    private Station arrivalStation;

    @Override
    public String toString() {
        return "Ticket: \n" +
                "passenger : " + user.getFullName() +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", paid=" + paid +
                ", price=" + price +
                ", departureStation=" + departureStation +
                ", arrivalStation=" + arrivalStation;
    }
}
