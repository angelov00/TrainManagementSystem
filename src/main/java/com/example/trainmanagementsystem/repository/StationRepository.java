package com.example.trainmanagementsystem.repository;

import com.example.trainmanagementsystem.model.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findStationByName(String name);
}
