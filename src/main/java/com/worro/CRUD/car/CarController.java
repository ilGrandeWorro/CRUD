package com.worro.CRUD.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService service;

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        return service.saveCar(car);
    }

    @GetMapping("/catalog")
    public List<Car> showAllCars() {
        return service.showCars();
    }

    @GetMapping("/{id}")
    public Optional<Car> showThisCarByID(@PathVariable long id) {
        return service.showCarByID(id);
    }

    @PutMapping("/edit/{id}")
    public Car changeTypeOfThisCarByID(@PathVariable long id, @RequestParam(required = false) String type) {
        return service.changeTypeOfCarWithID(id, type);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity removeThisCar(@PathVariable long id) throws ClassNotFoundException {
        try{
            service.deleteSpecificCar(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (ClassNotFoundException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/clear")
    public void deleteAllCars() {
        service.deleteAll();
    }
}
