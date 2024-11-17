package com.example.demo_client.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    private final HttpStatus[] statuses = {
            HttpStatus.OK,
            HttpStatus.NOT_FOUND,
            HttpStatus.INTERNAL_SERVER_ERROR,
            HttpStatus.BAD_REQUEST
    };
    private final Random random = new Random();

    @GetMapping("/response")
    public ResponseEntity<String> getResponse() {
        log.info("Client Hit:-----");
        HttpStatus randomStatus = statuses[random.nextInt(statuses.length)];
        log.info("Response: {}", randomStatus);
        return ResponseEntity.status(randomStatus).body(randomStatus.toString());
    }
}
