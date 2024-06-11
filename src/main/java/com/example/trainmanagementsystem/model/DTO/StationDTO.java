package com.example.trainmanagementsystem.model.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String municipality;
}
