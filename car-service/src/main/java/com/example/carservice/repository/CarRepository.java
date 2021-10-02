package com.example.carservice.repository;

import com.example.carservice.domain.Car;

import com.google.inject.internal.cglib.proxy.$FixedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


//@RepositoryRestResource
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
//    @Query(value="select c.id from carlist c where c.name= :name ", nativeQuery=true)
//    List<Car> getCarsByName(@Param("name") String name);

 List<Car> findCarsByName(String name);

  //  List<Car> findCarsByColor(String color);


//    @Query(Car)
//    Car getCarByName(String name);
//
//    @Query("select * ", native = "true")
//    Car getCarByNameNative(String name);
//    //TODO 3
//      String  getCarNameById(Long id);
}
