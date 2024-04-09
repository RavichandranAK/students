package com.car.repository;

import com.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepository extends JpaRepository<Car,Integer>{

}
