package com.example.metro.controller;

import com.example.metro.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<String> getRoute(
            @RequestParam String from,
            @RequestParam String to) {

        return routeService.findRoute(from, to);
    }
}