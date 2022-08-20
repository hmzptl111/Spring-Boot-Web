package com.map.presentation;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.map.bean.Employee;
import com.map.service.EmployeeService;

@Component
public class EmployeePresentationImpl implements EmployeePresentation {
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. List all employees");
		System.out.println("2. List all employees in department");
		System.out.println("3. List all managers in IT department");
		System.out.println("4. Count of designations");
		System.out.println("X. Any other key to exit");
		
		switch(sc.nextInt()) {
			case 1:
				List<Employee> employees = employeeService.findAllEmployees();
				for(Employee employee: employees) {
					System.out.println(employee);
				}
				break;
			case 2:
				System.out.println("Department: ");
				List<Employee> employeesInDepartment = employeeService.findEmployeesByDepartment(sc.next());
				for(Employee employee: employeesInDepartment) {
					System.out.println(employee);
				}
				break;
			case 3:
				List<Employee> managersInDepartment = employeeService.findManagersInDepartment("IT");
				for(Employee manager: managersInDepartment) {
					System.out.println(manager);
				}
				break;
			case 4:
				int designationCount = employeeService.getDistinctDesignationCount();
				System.out.println("There are " + designationCount + " designations");
				break;
			default:
				System.exit(0);
		}
		
		menu();
	}
}