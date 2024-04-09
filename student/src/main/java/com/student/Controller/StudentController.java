package com.student.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Service.StudentService;
import com.student.entity.Student;

@RestController
@RequestMapping("/home")
public class StudentController {
	@Autowired
	StudentService studentService;
	@PostMapping("/insertAll")
	public String insertAll(@RequestBody List<Student> s) {
		return studentService.insertAll(s);
	}
	
	@GetMapping("/findAll")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@GetMapping("/findNameByCourse/{course}") 
	public List<String> findNameByCourse(@PathVariable String course) {
		return studentService.findNameByCourse(course);
	}
	
	@GetMapping("/findIdAndNameBycollege/{college}") 
	public Map<Integer,String> findIdAndNameBycollege(@PathVariable String college) {
		return studentService.findIdAndNameBycollege(college);
	}
	
	@PutMapping("/deleteName/{name}") 
	public String deleteName(@PathVariable String name) {
		  return studentService.deleteName(name);
	}
	

}
