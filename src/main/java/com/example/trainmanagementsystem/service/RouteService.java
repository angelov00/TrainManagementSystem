package com.example.trainmanagementsystem.service;

import com.example.trainmanagementsystem.model.DTO.RouteDTO;
import com.example.trainmanagementsystem.model.entity.Route;
import com.example.trainmanagementsystem.repository.RouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RouteService(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<Route> findById(Long id) {
        return this.routeRepository.findById(id);
    }

    public void addRoute(RouteDTO routeDTO) {
        Route route = this.modelMapper.map(routeDTO, Route.class);
        this.routeRepository.save(route);
    }
}
