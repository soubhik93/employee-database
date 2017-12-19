package com.practise.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {

	@Id
	private String vin;
	
	@Column
	private String color;
	
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;
	
	

	public Vehicle(String vin, String color, Employee employee) {
		super();
		this.vin = vin;
		this.color = color;
		this.employee = employee;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
