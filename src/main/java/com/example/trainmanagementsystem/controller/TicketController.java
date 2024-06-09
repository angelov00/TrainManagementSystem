package com.example.trainmanagementsystem.controller;

import com.example.trainmanagementsystem.model.entity.Station;
import com.example.trainmanagementsystem.model.entity.Travel;
import com.example.trainmanagementsystem.service.StationService;
import com.example.trainmanagementsystem.service.TravelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final StationService stationService;
    private final TravelService travelService;

    public TicketController(StationService stationService, TravelService travelService) {
        this.stationService = stationService;
        this.travelService = travelService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Travel>> getTravelByStations(
            @RequestParam String startStationName,
            @RequestParam String endStationName) {

        Optional<Station> startStation = stationService.findByName(startStationName);
        Optional<Station> endStation = stationService.findByName(endStationName);

        if (startStation.isEmpty() || endStation.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Travel> potentialTravels = travelService.findByRouteContainingStations(startStation.get(), endStation.get());

        //we need to take the direction into consideration (boolean isValidTravel)
        List<Travel> validTravels = potentialTravels.stream()
                .filter(travel -> isValidTravel(travel.getRoute().getStations(), startStation.get(), endStation.get()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(validTravels);
    }

    private boolean isValidTravel(Set<Station> stations, Station startStation, Station endStation) {
        boolean foundStart = false;
        for (Station station : stations) {
            if (station.equals(startStation)) {
                foundStart = true;
            }
            if (foundStart && station.equals(endStation)) {
                return true;
            }
        }
        return false;
    }
}
