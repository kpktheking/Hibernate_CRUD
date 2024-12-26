package com.tap.main;

import java.util.List;

import com.tap.Entity.Employee;
import com.tap.manager.HibernateManager;

public class EmployeeApp {

	public static void main(String[] args) {
		HibernateManager hm=new HibernateManager();
//		Employee e=new Employee(2,"Pavan Kumar","IT",40000);
//		hm.add(e);
//		System.out.println("Object added");
//		System.out.println(hm.getUserById(2));
//		hm.updateObject(e);
//		System.out.println("Object updated");
//		hm.delete(3);
		List<Employee> empl=hm.getAllEmployees();
		for(Employee e:empl) {
			System.out.println(e);
		}
	}

}
