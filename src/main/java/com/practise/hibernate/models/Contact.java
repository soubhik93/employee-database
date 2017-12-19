package com.practise.hibernate.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	private Long phoneNumber;
	@Column
	private Long mobileNumber;
	
	@ManyToMany
	@JoinTable(name="employeeContact",joinColumns=@JoinColumn(name="contactId"),inverseJoinColumns=@JoinColumn(name="EmployeeId"))
	private List<Employee> employee;

	
	
	public Contact(Long phoneNumber, Long mobileNumber, List<Employee> employee) {
		super();
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.employee = employee;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	
	
}
