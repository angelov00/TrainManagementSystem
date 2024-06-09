package com.example.trainmanagementsystem.util;

import com.example.trainmanagementsystem.model.entity.Route;
import com.example.trainmanagementsystem.model.entity.Station;
import com.example.trainmanagementsystem.model.entity.Travel;
import com.example.trainmanagementsystem.repository.RouteRepository;
import com.example.trainmanagementsystem.repository.StationRepository;
import com.example.trainmanagementsystem.repository.TravelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class InitDB {

    private final StationRepository stationRepository;
    private final RouteRepository routeRepository;
    private final TravelRepository travelRepository;

    @Autowired
    public InitDB(StationRepository stationRepository, RouteRepository routeRepository, TravelRepository travelRepository) {
        this.stationRepository = stationRepository;
        this.routeRepository = routeRepository;
        this.travelRepository = travelRepository;
    }

    @PostConstruct
    void init() {

        Station station = new Station();
        station.setName("Vasil Levski");
        station.setMunicipality("Lovech");

        this.stationRepository.saveAndFlush(station);

        Station station1 = new Station();
        station1.setName("Sofia Central Station");
        station1.setMunicipality("Sofia");

        this.stationRepository.saveAndFlush(station1);

        Station station2 = new Station();
        station2.setName("Sofia North");
        station2.setMunicipality("Sofia");

        this.stationRepository.saveAndFlush(station2);

        Station station3 = new Station();
        station3.setName("Plovdiv Central");
        station3.setMunicipality("Plovdiv");

        this.stationRepository.saveAndFlush(station3);

        Route route = new Route();
        Set<Station> stations = new LinkedHashSet<>();
        stations.add(station);
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        route.setStations(stations);

        this.routeRepository.saveAndFlush(route);

        Travel travel = new Travel();
        travel.setRoute(route);
        travel.setTickets(new LinkedHashSet<>());
        travel.setTimetable(new LinkedHashSet<>());
        this.travelRepository.save(travel);
    }

}
