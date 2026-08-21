package com.example.metro.service;

import com.example.metro.graph.MetroGraph;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteService {

    private final MetroGraph metroGraph;

    public RouteService(MetroGraph metroGraph) {
        this.metroGraph = metroGraph;
    }

    public List<String> findRoute(String source, String destination) {

        Map<String, List<String>> graph = metroGraph.getGraph();

        if (!graph.containsKey(source)) {
            throw new RuntimeException("Source station not found: " + source);
        }
        if (!graph.containsKey(destination)) {
            throw new RuntimeException("Destination station not found: " + destination);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            String currentStation = queue.poll();
            if (currentStation.equals(destination)) {
                break;
            }

            for (String neighbour : graph.get(currentStation)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    parent.put(neighbour, currentStation);
                    queue.add(neighbour);
                }
            }
        }

        if (!visited.contains(destination)) {
            throw new RuntimeException(
                    "No route found from " + source + " to " + destination
            );
        }

        return buildRoute(source, destination, parent);
    }

    private List<String> buildRoute(
            String source,
            String destination,
            Map<String, String> parent) {

        List<String> route = new ArrayList<>();

        String current = destination;

        while (current != null) {

            route.add(current);

            if (current.equals(source)) {
                break;
            }

            current = parent.get(current);
        }

        Collections.reverse(route);

        return route;
    }
}