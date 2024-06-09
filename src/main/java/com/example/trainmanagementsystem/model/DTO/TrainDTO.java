package com.example.trainmanagementsystem.model.DTO;

import com.example.trainmanagementsystem.model.enumerations.TrainStatus;
import com.example.trainmanagementsystem.model.enumerations.TrainType;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainDTO {

    @Positive
    private short capacity;
    private TrainStatus trainStatus;
    private TrainType trainType;

}
