package com.sujata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@Column(name = "id")
	private int employeeId;
	@Column(name = "name")
	private String employeeName;
	@Column(name = "email")
	private String email;
	@Column(name = "designation")
	private String employeeDesignation;
	private String department;
	private double salary;
}
