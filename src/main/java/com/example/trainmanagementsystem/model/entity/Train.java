package com.example.trainmanagementsystem.model.entity;

import com.example.trainmanagementsystem.model.enumerations.TrainStatus;
import com.example.trainmanagementsystem.model.enumerations.TrainType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private short capacity;
    @Enumerated(EnumType.STRING)
    private TrainStatus trainStatus;
    @Enumerated(EnumType.STRING)
    private TrainType trainType;

}
