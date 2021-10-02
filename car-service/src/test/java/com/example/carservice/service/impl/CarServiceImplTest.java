package com.example.carservice.service.impl;

import com.example.carservice.domain.Car;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.service.CarService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {

    private CarService carService;

    private CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        carRepository = Mockito.mock(CarRepository.class);
        carService = new CarServiceImpl(carRepository);
    }


    @Test
    public void createAndSaveNewCarAssertNamedOpel() {
        Car car = new Car("Opel","Black");
        car.setId(1L);
        Mockito.when(carService.save(car)).thenReturn(car);
        Car expectedCar = carService.save(car);
        assertEquals(expectedCar.getName(), car.getName());

    }


    @Test
    public void createSaveUpdateSavedCarName() {
        Car car = new Car("Opel","Black");
        car.setId(1L);
        String name = "new";
        Mockito.when(carRepository.save(car)).thenReturn(car);
        Car expectedCar = carService.save(car);
        expectedCar.setName("newName");
        carService.carUpdate(expectedCar);
        Mockito.verify(carRepository,times(1)).save(car);


    }

    @Test
    public void createAndSaveNewCarsAndFindAllCars() {
        Car car = new Car("Opel","Black");
        car.setId(1L);
        Car car1 = new Car("Mazda","Red");
        car1.setId(2L);

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);

        Mockito.when(carService.save(car)).thenReturn(car);
        Mockito.when(carService.save(car1)).thenReturn(car1);
        Mockito.when(carRepository.findAll()).thenReturn(cars);

        List<Car> carsExp = carService.findAll();

        assertNotNull(carsExp);
        assertEquals(carsExp.size(), cars.size());
        assertEquals(carsExp.get(1), cars.get(1));
        assertEquals(carsExp.get(0), cars.get(0));
    }

    @Test
    public void createAndSaveCarAndFindById() {
        Car car = new Car("Opel","Black");
        car.setId(1L);
        Car car1 = new Car("Mazda","Red");
        car1.setId(2L);

        Mockito.when(carService.save(car)).thenReturn(car);
        Mockito.when(carService.save(car1)).thenReturn(car1);
        Mockito.when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));
        Mockito.when(carRepository.findById(car1.getId())).thenReturn(Optional.of(car1));

        Optional<Car> expectedCar = carService.findById(1L);
        Optional<Car> expectedCar1 = carService.findById(2L);

        assertNotNull(expectedCar);
        assertNotNull(expectedCar1);
        assertNotEquals(expectedCar, expectedCar1);
        assertEquals(expectedCar.get().getId(), car.getId());
        assertEquals(expectedCar1.get().getId(), car1.getId());

    }

    @Test
    public void createAndDeleteCarById() {

        Car car = new Car("Opel","Black");
        car.setId(1L);

        Mockito.when(carRepository.save(car)).thenReturn(car);
        Car expectedCar = carService.save(car);
        assertEquals(car.getId(), expectedCar.getId());
        carService.delete(1L);
        Mockito.verify(carRepository).deleteById(1L);

    }


    @After
    public void tearDown() throws Exception {
        carService = null;

    }
}