package com.example.trainmanagementsystem.controller;

import com.example.trainmanagementsystem.model.DTO.TrainDTO;
import com.example.trainmanagementsystem.service.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping("/add")
    ResponseEntity<Void> addTrain(@Valid @RequestBody TrainDTO trainDTO) {
        this.trainService.addTrain(trainDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
