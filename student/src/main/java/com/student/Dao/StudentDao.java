package com.student.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.Repository.StudentRepo;
import com.student.entity.Student;
@Repository
public class StudentDao {
	@Autowired
	StudentRepo studentRepo;
	
	public String insertAll(List<Student> s) {
		studentRepo.saveAll(s);
		return "Successfully Inserted";
	}
	
	public List<Student> findAll() {
		return studentRepo.findAll();
	}
	
	public String mydel(int b) {
		
		studentRepo.deleteById(b);
		return "ok";
		
	}

}
