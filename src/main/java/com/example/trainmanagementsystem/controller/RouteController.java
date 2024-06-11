package com.example.trainmanagementsystem.controller;

import com.example.trainmanagementsystem.model.DTO.RouteDTO;
import com.example.trainmanagementsystem.model.entity.Route;
import com.example.trainmanagementsystem.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Route> getById(@RequestParam Long id) {
        Optional<Route> route = this.routeService.findById(id);
        return route.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    private ResponseEntity<Void> addRoute(@Valid @RequestBody RouteDTO routeDTO) {

        this.routeService.addRoute(routeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
