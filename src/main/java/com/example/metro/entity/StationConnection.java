package com.example.metro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "station_connections")
public class StationConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_station_id", nullable = false)
    private Station fromStation;

    @ManyToOne
    @JoinColumn(name = "to_station_id", nullable = false)
    private Station toStation;

    public StationConnection() {
    }

    public StationConnection(Station fromStation, Station toStation) {
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public Long getId() {
        return id;
    }

    public Station getFromStation() {
        return fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    public void setFromStation(Station fromStation) {
        this.fromStation = fromStation;
    }

    public void setToStation(Station toStation) {
        this.toStation = toStation;
    }
}