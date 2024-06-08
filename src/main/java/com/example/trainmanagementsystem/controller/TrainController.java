package com.example.trainmanagementsystem.controller;

import com.example.trainmanagementsystem.model.DTO.TrainDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @PostMapping("/add")
    ResponseEntity<Void> addTrain(@RequestBody TrainDTO trainDTO) {

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
