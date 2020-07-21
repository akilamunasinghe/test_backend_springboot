package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/route", produces = "application/json")
    public ResponseEntity<response> getRoute() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response obj = new response("http://172.31.25.189:8080");
        return ResponseEntity.status(200).body(obj);
    }

    @PostMapping(value = "/sample",consumes = "application/json",  produces = "application/json")
    public ResponseEntity<response> samplePost(HttpEntity<String> httpEntity) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);

        //String json = httpEntity.getBody();
        //System.out.println(json);
        
        response obj = new response("Hello post");
        return ResponseEntity.status(200).body(obj);
    }

    @GetMapping(value = "/sample", produces = "application/json")
    public ResponseEntity<response> sampleGet() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response obj = new response("Hello get");
        return ResponseEntity.status(200).body(obj);
    }
}
