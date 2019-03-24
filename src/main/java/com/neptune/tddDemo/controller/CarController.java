package com.neptune.tddDemo.controller;

import com.neptune.tddDemo.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/cars/{name}")
    private Car getCarByName(@PathVariable String name){
        return null;
    }

}
