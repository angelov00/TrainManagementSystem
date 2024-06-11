package com.example.trainmanagementsystem.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    @NotEmpty
    Set<StationDTO> stations;
    @NotBlank
    private String municipality;
}
