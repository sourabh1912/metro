package com.example.metro.repository;

import com.example.metro.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findByNameIgnoreCase(String name);
}