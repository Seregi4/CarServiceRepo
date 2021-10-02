package com.example.carservice.web.rest;


import com.example.carservice.domain.Car;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.service.CarService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.jhipster.web.util.ResponseUtil;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Transactional
@Tag(name = "Car controller", description = "Взаимодействие с машинами(добавить, найти, удалить, вывести все")
public class CarController {
    private final Logger log = LoggerFactory.getLogger(CarController.class);
    private static final String ENTITY_NAME = "car";


    private final CarRepository carRepository;
    private final CarService carService;

    public CarController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @GetMapping("/cars")
    @Operation(
            summary = "Получение списка машин",
            description = "Позволяет получить список всех машин"
    )
    public List<Car> getAllCars() {
        log.debug("REST request to get all Cars");
        return carService.findAll();
    }

    @PostMapping("/cars")
    @Operation(
            summary = "Создание новой машины",
            description = "Добавляет новую машину в список машин"
    )
    public ResponseEntity<Car> createCar(@RequestBody Car car) throws URISyntaxException {
        log.debug("REST request to save Car : {}", car);
        if (car.getId() != null) {

        }
        Car result = carService.save(car);

        return ResponseEntity
                .created(new URI("/api/cars/" + result.getId())).body(result);
    }

    @PutMapping("/cars/{id}")
    @Operation(
            summary = "Обновление машины",
            description = "Позволяет обновить данные машины"
    )
    public ResponseEntity<?> partialUpdateCar(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Car car
    ) throws URISyntaxException {
        log.debug("REST request to partial update Country partially : {}, {}", id, car);
        if (car.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
            //  throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, car.getId())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
            //  throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!carRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            //  throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Car> result = carService.carUpdate(car);
        return new ResponseEntity(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/cars/{id}")
    @Operation(
            summary = "получени машины по id",
            description = "Позволяет получить машину по id"
    )
    public ResponseEntity<Car> getCarByID(@PathVariable Long id) {
        log.debug("REST request to get Car : {}", id);
        Optional<Car> car = carService.findById(id);
        return ResponseUtil.wrapOrNotFound(car);
    }

    @DeleteMapping("/cars/{id}")
    @Operation(
            summary = "Удаление машины по id",
            description = "Позволяет удалить машину по id"
    )
    public void deleteCarByID(@PathVariable Long id) {
        log.debug("REST request to delete Car : {}", id);
        carService.delete(id);

    }
    @GetMapping("/cars/{name}")
    @Operation(
            summary = "получени машин по имени",
            description = "Позволяет получить машины по name"
    )
    public List<Car>  getAllCarByName(@PathVariable String name){
        log.debug("REST request to get Cars : {}", name);

        return carService.findAll();
    }
//
//    @GetMapping("/cars/{color}")
//    @Operation(
//            summary = "получени машин по ",
//            description = "Позволяет получить машину по color"
//    )
//    public List<Car>  getAllCarByColor(@PathVariable String color){
//        log.debug("REST request to get Cars : {}", color);
//
//        return carService.findAllByColor(color);
//    }



}
