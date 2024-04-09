package com.Student.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Student.Entity.Results;
import com.Student.Repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository studentrepo;

	public void access(Results r) {
		studentrepo.save(r);
	}

	public List<Results> findAll() {
		return studentrepo.findAll();
	}

}
