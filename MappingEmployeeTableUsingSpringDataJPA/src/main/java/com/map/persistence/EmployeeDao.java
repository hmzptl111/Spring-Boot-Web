package com.map.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.map.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByDepartment(String department);
	
	List<Employee> findByDesignationAndDepartment(String designation, String department);
	
	@Query(value = "select count(distinct(designation)) from Employee")
	int getDistinctDesignationCount();
}
