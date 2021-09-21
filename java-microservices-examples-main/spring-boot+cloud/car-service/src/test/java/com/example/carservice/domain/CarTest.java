package com.example.carservice.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car = null;
    private Car carNoArgs = null;

    @Before
    public void setUp() throws Exception {
        car = new Car("Opel");
        carNoArgs = new Car();
    }


//    @Test
//    public void getName() {
//        String carStr = "Bmw";
//        car.setName(carStr);
//        assertEquals(carStr,car.getName());
//    }
//    @Test
//    public void getId() {
//        long carID = 1;
//        car.setId(carID);
//        assertEquals(Long.toString(carID),car.getId().toString());
//    }

    @Test
    public void testGettersAndSetters() {
        String carStr = "Bmw";
        car.setName(carStr);
        assertEquals(carStr, car.getName());

        long carID = 1;
        car.setId(carID);
        assertEquals(Long.toString(carID), car.getId().toString());
    }

    @Test
    public void testConstructors() {
        assertNotNull(carNoArgs);
    }


    @Test
    public void testEquals() {
        assertEquals(carNoArgs.equals(car), car.equals(carNoArgs));
    }

    @Test
    public void canEqual() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testToString() {
        System.out.println(car.toString());
        assertEquals("Car(id=null, name=Opel)",car.toString());
    }

    @After
    public void tearDown() throws Exception {
        car = null;
        carNoArgs = null;
    }
}