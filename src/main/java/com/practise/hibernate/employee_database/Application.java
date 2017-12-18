package com.practise.hibernate.employee_database;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.models.Address;
import com.practise.hibernate.models.Contact;
import com.practise.hibernate.models.Employee;
import com.practise.hibernate.models.Vehicle;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		session.beginTransaction();
		
		
		
		Address address=new Address("Neeladri nagar", 103, "Bangalore");
		Address address2=new Address("Greenpark", 41, "Kolkata");
		
		session.save(address);
		session.save(address2);
		
		Employee employee=new Employee();
		employee.setEmpId(123);
		employee.setName("Leonard");
		employee.setSalary(20000);
		employee.setAddress(address);
		
		Employee employee2=new Employee();
		employee2.setEmpId(134);
		employee2.setName("Penny");
		employee2.setSalary(30000);
		employee2.setAddress(address2);
		
		Vehicle vehicle=new Vehicle("11123", "Red", employee);
		Vehicle vehicle2=new Vehicle("2221111", "Balcak", employee);
		Vehicle vehicle3=new Vehicle("11123221", "White", employee2);
		Vehicle vehicle4=new Vehicle("2224431", "Grey", employee2);
		
		employee.setVehicle(Arrays.asList(vehicle,vehicle2));
		employee2.setVehicle(Arrays.asList(vehicle3,vehicle4));
		
		Contact contact=new Contact(1234l, 99999l, Arrays.asList(employee,employee2));
		
		Contact contact2=new Contact(12345l, 999899l, Arrays.asList(employee,employee2));
		
		employee.setContacts(Arrays.asList(contact,contact2));
		employee2.setContacts(Arrays.asList(contact,contact2));
		
		session.save(contact);
		session.save(contact2);
		
		session.save(vehicle);
		session.save(vehicle2);
		session.save(vehicle3);
		session.save(vehicle4);
		
		session.save(employee);
		session.save(employee2);
		
	
		session.getTransaction().commit();
	
		Employee emp=(Employee)session.get(Employee.class, 123);
		
		System.out.println("Employee Details:  "+emp.getName()+"   "+emp.getEmpId()+"   "+emp.getSalary());
		
		session.close();
		factory.close();
	}

}
