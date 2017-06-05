package de.roamingthings.workbench.cicd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/ping")
    public ResponseEntity ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/greeting")
    public ResponseEntity greeting(@RequestBody String name) {
        return ResponseEntity.ok("Hello " + name);
    }
}
