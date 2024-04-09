package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Exception.AgeException;
import com.employee.Exception.NewAgeException;
import com.employee.Exception.NonameException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;
    //CHECK ALL VLAUES IF NULL HANDLE EXCEPTION OR INSERT INTO TABLE
	public String addEmployee(Employee e) {
		if (e.getGender() == null || e.getGender() == "") {
			throw new NullPointerException("Gender is Empty");
		} else if (e.getAge() == 0) {
			throw new NullPointerException("Age is Empty");
		} else if (e.getDesignation() == null) {
			throw new NullPointerException("Designation is Empty");
		} else if (e.getFirstName() == null) {
			throw new NullPointerException("First_Name is Empty");
		} else if (e.getLastName() == null) {
			throw new NullPointerException("Last_name is Empty");
		} else if (e.getSalary() == 0) {
			throw new NullPointerException("Salary is Empty");
			
		} else {
			return empdao.addEmployee(e);
		}

	}

	// INSERT LIST OF EMPLOYEES AND IF AGE LESS THAN 18 HANDLE EXCEPTION
	public String addEmployees(List<Employee> e) throws NewAgeException {
		int count = 0;
		for (Employee x : e) {
			if (x.getAge() < 18) {
				count--;
			} else {
				count++;
			}
		}
		if (count == e.size()) {
			return empdao.addEmployees(e);
		} else {
			throw new NewAgeException("One Of the Object's age is lessthan 18");
		}

	}

	public Employee getId(int a) {
		return empdao.getId(a);
	}

	public List<Employee> findAll() {
		return empdao.findAll();
	}

	public String delete(int a) {
		return empdao.delete(a);
	}

	public String update(Employee e) {
		return empdao.update(e);
	}

	public String postBulk(List<Employee> e) {
		return empdao.postBulk(e);
	}

	public List<Employee> getByName(String name) throws Exception {
		List<Employee> temp = empdao.findAll();
		List<Employee> temp1 = temp.stream().filter(x -> x.getFirstName().equalsIgnoreCase(name)).toList();
		if (temp1.isEmpty()) {
			throw new NonameException("No such name found");
		} else {
			return temp1;
		}
	}

	public List<Employee> getByAge(int age) {
		List<Employee> temp = empdao.findAll();
		return temp.stream().filter(x -> x.getAge() == age).toList();

	}

	public List<Employee> getBySalary(int salary) {
		List<Employee> temp = empdao.findAll();
		return temp.stream().filter(x -> x.getSalary() == 35000).toList();

	}

	public List<Employee> getByDesignation(String des) {
		List<Employee> temp = empdao.findAll();
		return temp.stream().filter(x -> x.getDesignation().equalsIgnoreCase(des)).toList();

	}

	public List<Employee> getByGender(String gender) {
		List<Employee> temp = empdao.findAll();
		return temp.stream().filter(x -> x.getGender().equalsIgnoreCase(gender)).toList();

	}

	public List<String> getDesBySalary(int a) {
		List<Employee> temp = empdao.findAll();
		return temp.stream().filter(x -> x.getSalary() > a).map(x -> x.getDesignation()).toList();

	}

	public List<String> getNameByGender(String a) {
		List<Employee> temp = empdao.findAll();
		return temp.stream().filter(x -> x.getGender().equalsIgnoreCase(a)).map(x -> x.getFirstName()).toList();

	}

	public String myupdate(Employee a) {
		return empdao.myupdate(a);
	}

	public List<Employee> getBetweenSalary(int sal1, int sal2) {
		return empdao.getBetweenSalary(sal1, sal2);
	}

	public List<Employee> getAllByGenderSalaryDesc(String gender) {
		return empdao.getAllByGenderSalaryDesc(gender);
	}

	public List<Object[]> getAgeDesByfName(String name) {
		return empdao.getAgeDesByfName(name);
	}

	public List<Employee> getAllJpa() {
		return empdao.getAllJpa();
	}

	public List<Employee> getByAgeJpa(int age) {
		return empdao.getByAgeJpa(age);
	}

	public List<Employee> getByAgeBetJpa(int age1, int age2) {
		return empdao.getByAgeBetJpa(age1, age2);
	}

	public String insertException(Employee e) throws AgeException {
		try {
			if (e.getAge() < 18) {
				throw new AgeException();
			} else {
				return empdao.insertException(e);
			}
		} catch (AgeException e1) {
			return "Given Age is Below 18";
		}
	}

}
