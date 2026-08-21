package com.example.metro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
public class InstanceController {

    @GetMapping("/instance")
    public Map<String, String> getInstance() throws UnknownHostException {

        return Map.of(
                "instance", InetAddress.getLocalHost().getHostName()
        );
    }

//    @GetMapping("/instance")
//    public String instance() {
//        return System.getenv("HOSTNAME");
//    }
}