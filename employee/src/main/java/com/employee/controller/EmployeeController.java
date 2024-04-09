package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.Exception.AgeException;
import com.employee.Exception.NewAgeException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.student.entity.Student;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	RestTemplate r;
	
	@Autowired
	EmployeeService empser;

	@PostMapping("/insert")
	public String addEmployee(@RequestBody Employee e) {
		return empser.addEmployee(e);
	}

	// INSERT LIST OF EMPLOYEES AND IF AGE LESS THAN 18 HANDLE EXCEPTION
	@PostMapping("/insertAll")
	public String addEmployees(@RequestBody List<Employee> e) throws NewAgeException {
		return empser.addEmployees(e);
	}

	@GetMapping("/getById/{a}")
	public Employee getId(@PathVariable int a) {
		return empser.getId(a);
	}

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return empser.findAll();
	}

	@DeleteMapping("/deleteById/{a}")
	public String delete(@PathVariable int a) {
		return empser.delete(a);
	}

	@PutMapping("/update")
	public String update(@RequestBody Employee e) {
		return empser.update(e);
	}

	@PostMapping("/bulkpost")
	public String postBulk(@RequestBody List<Employee> e) {
		return empser.postBulk(e);
	}

	@GetMapping("/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) throws Exception {
		return empser.getByName(name);
	}

	@GetMapping("/getByAge/{age}")
	public List<Employee> getByAge(@PathVariable int age) {
		return empser.getByAge(age);
	}

	@GetMapping("/getBySalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empser.getBySalary(salary);
	}

	@GetMapping("/getByDesignationz/{des}")
	public List<Employee> getByDesignation(@PathVariable String des) {
		return empser.getByDesignation(des);
	}

	@GetMapping("/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return empser.getByGender(gender);
	}

	@GetMapping("/getDesBySalary/{a}")
	public List<String> getDesBySalary(@PathVariable int a) {
		return empser.getDesBySalary(a);
	}

	@GetMapping("/getNameByGender/{a}")
	public List<String> getNameByGender(@PathVariable String a) {
		return empser.getNameByGender(a);
	}

	@PutMapping("/myupdate")
	public String myupdate(@RequestBody Employee a) {
		return empser.myupdate(a);
	}

	@GetMapping("/getBetweenSalary")
	public List<Employee> getBetweenSalary(@RequestParam int sal1, @RequestParam int sal2) {
		return empser.getBetweenSalary(sal1, sal2);
	}

	@GetMapping("/getAllByGenderSalaryDesc")
	public List<Employee> getAllByGenderSalaryDesc(@RequestParam String gender) {
		return empser.getAllByGenderSalaryDesc(gender);
	}

	@GetMapping("/getAgeDesByfName")
	public List<Object[]> getAgeDesByfName(@RequestParam String name) {
		return empser.getAgeDesByfName(name);
	}

	@GetMapping("/getAllJpa")
	public List<Employee> getAllJpa() {
		return empser.getAllJpa();
	}

	@GetMapping("/getByAgeJpa/{age}")
	public List<Employee> getByAgeJpa(@PathVariable int age) {
		return empser.getByAgeJpa(age);
	}

	@GetMapping("/getByAgeBetJpa/{age1}/{age2}")
	public List<Employee> getByAgeBetJpa(@PathVariable int age1, @PathVariable int age2) {
		return empser.getByAgeBetJpa(age1, age2);
	}

	@PostMapping("/insertException")
	public String insertException(@RequestBody Employee e) throws AgeException {
		return empser.insertException(e);
	}
	
	@GetMapping("/viaEmployee")
	public List<Student> viaEmployee() {
		String url="http://localhost:8080/home/findAll";
		ResponseEntity<List<Student>> res=r.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<Student>>(){});
		return res.getBody();
	}
	

}
