package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.carDao;
import com.car.entity.Car;
@Service
public class carService {
	@Autowired
	carDao carDao;

	public String addlist(List<Car> c){
		return carDao.addlist(c);
	}
	
	public Car getId(int a) {
		return carDao.getId(a);
	}
	
	public List<Car> findAll() {
		return carDao.findAll();
	}
	public String update(Car a) {
		return carDao.update(a);
	}
	public String delete(int a) {
		return carDao.delete(a);
	}
}
