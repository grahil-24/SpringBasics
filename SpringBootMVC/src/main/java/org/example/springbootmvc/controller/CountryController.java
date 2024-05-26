package org.example.springbootmvc.controller;


import org.example.springbootmvc.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    //response entity class helps us to modify response status, header and body
    public ResponseEntity<Country> france() {
        //By default, Spring creates a string representation of the object and
        //formats it as JSON
        Country country = Country.of("France", 67);
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("continent", "europe")
                .header("capital", "Paris").body(country);
    }

    //also send object collection instances in the response body
    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 47);
        return List.of(c1,c2);
    }
}
