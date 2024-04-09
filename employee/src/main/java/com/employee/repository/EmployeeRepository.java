package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employees where salary>=? and salary <=?", nativeQuery = true)
	public List<Employee> getSalaryBetween(int sal1, int sal2);

	@Query(value = "select * from employees where gender like %?% order by salary desc", nativeQuery = true)
	public List<Employee> getAllByGenderSalaryDesc(String gender);

	@Query(value = "select age,designation from employees where first_name like %?%", nativeQuery = true)
	public List<Object[]> getAgeDesByfName(String name);

	@Query(value = "select e from Employee e")
	public List<Employee> getAllJpa();

	@Query(value = "select e from Employee e where e.age=%?1%")
	public List<Employee> getByAgeJpa(int age);

	@Query(value = "select e from Employee e where e.age between ?1 and ?2")
	public List<Employee> getByAgeBetJpa(int age1, int age2);

}
