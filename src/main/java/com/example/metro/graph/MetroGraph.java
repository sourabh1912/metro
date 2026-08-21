package com.example.metro.graph;

import com.example.metro.entity.StationConnection;
import com.example.metro.repository.StationConnectionRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MetroGraph {

    private final Map<String, List<String>> graph = new HashMap<>();

    public MetroGraph(StationConnectionRepository connectionRepository) {

        List<StationConnection> connections =
                connectionRepository.findAll();

        for (StationConnection connection : connections) {

            String from = connection
                    .getFromStation()
                    .getName();

            String to = connection
                    .getToStation()
                    .getName();

            graph
                    .computeIfAbsent(from, k -> new ArrayList<>())
                    .add(to);

            graph
                    .computeIfAbsent(to, k -> new ArrayList<>())
                    .add(from);
        }
    }

    public Map<String, List<String>> getGraph() {
        return graph;
    }
}