package com.worro.CRUD.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public Car saveCar(Car car) {
        return repository.save(car);
    }

    public List<Car> showCars() {
        return repository.findAll();
    }

    public Optional<Car> showCarByID(long id) {
        if (!repository.existsById(id)) {
            return Optional.of(new Car());
        }
        return repository.findById(id);
    }


    public Car changeTypeOfCarWithID(long id, String type) {
        if (!repository.existsById(id)) {
            return new Car();
        }
        Car result = repository.getReferenceById(id);
        result.setType(type);
        return repository.save(result);
    }

    public void deleteSpecificCar(long id) throws ClassNotFoundException {
        if(!repository.existsById(id)){
            throw new ClassNotFoundException();
        }
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
