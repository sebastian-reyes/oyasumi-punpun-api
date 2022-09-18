package com.manga.punpun.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeRestController {

    @GetMapping("/")
    public ResponseEntity<?> home(){
        Map<String, Object> response = new HashMap<>();
        //response.put("Volume","http://localhost:9898/api/volume");
        response.put("Characters","http://localhost:9898/api/character/page/0");
        //response.put("Chapters","http://localhost:9898/api/chapter");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
