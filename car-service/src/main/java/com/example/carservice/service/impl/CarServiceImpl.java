package com.example.carservice.service.impl;

import com.example.carservice.domain.Car;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.service.CarService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);
    @Autowired
    private CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Car save(Car car) {

        log.debug("Request to save Car : {}", car);

        return carRepository.save(car);
    }

    @Override
    public Optional<Car> carUpdate(Car car) {
        log.debug("Request to partially update Car : {}", car);
        return carRepository
                .findById(car.getId())
                .map(
                        existingCar -> {
                            if (car.getName() != null) {
                                existingCar.setName(car.getName());
                            }
                            return existingCar;
                        }
                )
                .map(carRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        log.debug("Request to get all Cars");
        return carRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Car> findById(Long id) {
        log.debug("Request to get Car : {}", id);
        return carRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Car : {}", id);
        carRepository.deleteById(id);

    }

    @Override
    public List<Car> findCarsByName(String name) {
        log.debug("Request to get Car : {}", name);
        return carRepository.findAll();
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<Car> findAllByName(String name) {
//        log.debug("Request to get Cars : {}", name);
//        List<Car>cars=carRepository.findAll();
//        List<Car>carsByName=new ArrayList<>();
//        for (Car car:cars) {
//            if(car.getName().equals(name)){
//                carsByName.add(car);
//            }
//        }
//        return carsByName;
//    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<Car> findAllByColor(String color) {
//        log.debug("Request to get all Cars by color");
//        return  carRepository.findAllByColor(color);
//    }


}
