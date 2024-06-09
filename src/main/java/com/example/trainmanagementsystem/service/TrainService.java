package com.example.trainmanagementsystem.service;

import com.example.trainmanagementsystem.model.DTO.TrainDTO;
import com.example.trainmanagementsystem.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void addTrain(TrainDTO trainDTO) {

    }
}
