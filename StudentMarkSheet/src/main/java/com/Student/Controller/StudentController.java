package com.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Entityy.MarkSheet;
import com.Student.Service.StudentService;
@RestController
@RequestMapping("/home")
public class StudentController {
	
	@Autowired
	StudentService studentser;
	
	@PostMapping("/insert") 
	public String insert(@RequestBody MarkSheet m) {
		return studentser.insert(m);
	}
	@GetMapping("/findAll")
	public List<MarkSheet> findAll() {
		return studentser.findAll();
	}
	
	@GetMapping("/findTotal")
    public List<Integer> findTotal(){
		return studentser.findTotal();
	}
	
	

}
