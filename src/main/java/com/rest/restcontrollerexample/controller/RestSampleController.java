package com.rest.restcontrollerexample.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSampleController {

    @GetMapping("/")
    public String welcome() {
        return "Hello Rest";
    }

    @GetMapping(path = "/api/v1/rest", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> rest() {
        return ResponseEntity
                .ok()
                .body("Rest API Test");
    }
}
