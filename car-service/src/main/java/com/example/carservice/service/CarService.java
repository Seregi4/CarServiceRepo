package com.example.carservice.service;

import com.example.carservice.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car save(Car car);

    Optional<Car> carUpdate(Car car);

    List<Car> findAll();

    Optional<Car> findById(Long id);

    void delete(Long id);

    List<Car> findCarsByName(String name);

 //   List<Car> findAllByColor(String color);

}
