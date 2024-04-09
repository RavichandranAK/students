package com.car.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.entity.Car;
import com.car.repository.carRepository;
@Repository
public class carDao {
	@Autowired
	carRepository carRepo;
	
	public String addlist(List<Car> c) {
		carRepo.saveAll(c);
		return "Successfully Stored";
	}
	
	public Car getId(int a) {
		return carRepo.findById(a).get();
	}
	
	public List<Car> findAll() {
		return carRepo.findAll();
	}
    
	public String update(Car a) {
		 carRepo.save(a);
		 return "Updated Successfully";
	}
	public String delete(int a) {
		 carRepo.deleteById(a);
		 return "Deleted Successfully";
	}

}
