package com.example.carservice.service.impl;

import com.example.carservice.domain.Car;
import com.example.carservice.repository.CarRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {
    @Mock
    CarRepository carRepository;

    private CarServiceImpl carService = null;

    private Car car = null;
    private Car car1 = null;
    private Car car2 = null;


    @Before
    public void setUp() throws Exception {

        carService = new CarServiceImpl(carRepository);

        car = new Car("Opel");
        car1 = new Car("BMW");
        car2 = new Car("MAZDA");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
    }


    @Test// (expected = NullPointerException.class)
    public void save() {

        carService.save(car);

        Mockito.when(carService.save(car)).thenReturn(car);
        assertNotNull(carService.save(car));
    }

    @Test
    public void carUpdate() {
        carService.carUpdate(car);
    }

    @Test
    public void findAll() {
        carService.findAll();
    }

    @Test
    public void findOne() {
    }

    @Test
    public void delete() {
    }
    @After
    public void tearDown() throws Exception {

    }
}