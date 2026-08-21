package com.example.metro.repository;

import com.example.metro.entity.StationConnection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationConnectionRepository
        extends JpaRepository<StationConnection, Long> {
}