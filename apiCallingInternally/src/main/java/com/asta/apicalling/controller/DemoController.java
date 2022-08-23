package com.asta.apicalling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/display")
    public String display(){
        return "Hello";
    }

    @GetMapping( value = "/callingApi")
    public String getDisplay(){
        String uri = "http://localhost:8080/display";
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping( value = "/countries")
    public List<Object> getCountries(){
        String uri = "http://restcountries.eu/rest/v2/all";
        Object[] countries = restTemplate.getForObject(uri, Object[].class);
        return Arrays.asList(countries);
    }
}
