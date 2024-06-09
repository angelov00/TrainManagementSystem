package com.example.trainmanagementsystem.service;

import com.example.trainmanagementsystem.model.entity.Station;
import com.example.trainmanagementsystem.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StationService {

    private final StationRepository stationRepository;

    @Autowired
    private StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Optional<Station> findByName(String name) {
        System.out.println("Trying to get: " + name);
        Optional<Station> result = this.stationRepository.findStationByName(name);
        System.out.println("Found: " + result.toString());
        return result;
    }


}
