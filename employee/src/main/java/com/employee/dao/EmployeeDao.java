package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository emprepo;

	public String addEmployee(Employee e) {
		emprepo.save(e);
		return "Successfully Saved";

	}

	// INSERT LIST OF EMPLOYEES AND IF AGE LESS THAN 18 HANDLE EXCEPTION
	public String addEmployees(List<Employee> e) {
		emprepo.saveAll(e);
		return "Successfully Saved";

	}

	public Employee getId(int a) {
		return emprepo.findById(a).get();
	}

	public List<Employee> findAll() {
		return emprepo.findAll();
	}

	public String delete(int a) {
		emprepo.deleteById(a);
		return "Deleted Successfully";
	}

	public String update(Employee e) {
		emprepo.save(e);
		return "Updated Successfully";
	}

	public String postBulk(List<Employee> e) {
		emprepo.saveAll(e);
		return "Successfully saved";
	}

	public String myupdate(Employee a) {
		emprepo.save(a);
		return "ok";

	}

	public List<Employee> getBetweenSalary(int sal1, int sal2) {
		return emprepo.getSalaryBetween(sal1, sal2);
	}

	public List<Employee> getAllByGenderSalaryDesc(String gender) {
		return emprepo.getAllByGenderSalaryDesc(gender);
	}

	public List<Object[]> getAgeDesByfName(String name) {
		return emprepo.getAgeDesByfName(name);
	}

	public List<Employee> getAllJpa() {
		return emprepo.getAllJpa();
	}

	public List<Employee> getByAgeJpa(int age) {
		return emprepo.getByAgeJpa(age);
	}

	public List<Employee> getByAgeBetJpa(int age1, int age2) {
		return emprepo.getByAgeBetJpa(age1, age2);
	}

	public String insertException(Employee e) {
		emprepo.save(e);
		return "Inserted Without Exception";
	}

}
