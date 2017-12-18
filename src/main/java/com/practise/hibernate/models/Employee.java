package com.practise.hibernate.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Column
	private String name;
	
	@Id
	private Integer empId;
	
	@Column
	private Integer salary;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToMany(mappedBy="employee")
	private Collection<Vehicle> vehicle;
	
	@ManyToMany(mappedBy="employee")
	private List<Contact> contacts;
	
	
	

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
