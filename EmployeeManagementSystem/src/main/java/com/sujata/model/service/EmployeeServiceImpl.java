package com.sujata.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sujata.bean.Employee;
import com.sujata.bean.EmployeePayslip;
import com.sujata.model.persistence.EmployeeDao;
import com.sujata.model.persistence.EmployeeDaoImpl;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int employeeId) {
		return employeeDao.searchRecord(employeeId);
	}

	/*
	 * HR= 15% of Basic
	 * DA= 18% of Basic
	 * PF= 12% of Basic
	 */
	@Override
	public EmployeePayslip generatePayslip(int employeeId) {
		Employee employee=employeeDao.searchRecord(employeeId);
		EmployeePayslip employeePayslip=null;
		if(employee!=null) {
		double hr=.15*employee.getSalary();
		double da=.18*employee.getSalary();
		double pf=.12*employee.getSalary();
		double total=employee.getSalary()+hr+da-pf;
		employeePayslip=new EmployeePayslip(employee, hr, pf, da, total);
		}
		return employeePayslip;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(employeeDao.addRecord(employee)>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		if(employeeDao.deleteRecord(employeeId)>0)
			return true;
		return false;
	}

}
