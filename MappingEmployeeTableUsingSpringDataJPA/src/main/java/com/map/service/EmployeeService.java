package com.map.service;

import java.util.List;

import com.map.bean.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployees();
	
	List<Employee> findEmployeesByDepartment(String department);
	
	List<Employee> findManagersInDepartment(String department);
	
	int getDistinctDesignationCount();
}
