package com.Student.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Student.Entityy.MarkSheet;
import com.Student.Repository.StudentRepository;
@Repository
public class StudentDao {
	@Autowired
	StudentRepository studentrepo;
	
	public String insert(MarkSheet m) {
		 studentrepo.save(m);
		 return "Inserted";
	}
	public List<MarkSheet> findAll() {
		return studentrepo.findAll();
	}
	
	

}
