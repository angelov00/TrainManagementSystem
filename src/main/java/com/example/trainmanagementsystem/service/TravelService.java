package com.example.trainmanagementsystem.service;

import com.example.trainmanagementsystem.model.entity.Station;
import com.example.trainmanagementsystem.model.entity.Travel;
import com.example.trainmanagementsystem.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    @Autowired
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public List<Travel> findByRouteContainingStations(Station startStation, Station endStation) {
        return this.travelRepository.findByRouteContainingStations(startStation, endStation);
    }
}
