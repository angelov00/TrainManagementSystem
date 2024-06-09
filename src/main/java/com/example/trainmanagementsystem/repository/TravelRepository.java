package com.example.trainmanagementsystem.repository;

import com.example.trainmanagementsystem.model.entity.Station;
import com.example.trainmanagementsystem.model.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("SELECT t FROM travels t JOIN t.route r WHERE :startStation MEMBER OF r.stations AND :endStation MEMBER OF r.stations")
    List<Travel> findByRouteContainingStations(@Param("startStation") Station startStation, @Param("endStation") Station endStation);
}
